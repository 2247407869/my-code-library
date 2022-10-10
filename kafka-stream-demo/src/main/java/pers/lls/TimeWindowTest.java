package pers.lls;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Properties;

/**
 *
 */
public class TimeWindowTest {
    private static final String BOOT_STRAP_SERVERS = "10.1.11.53:9192";
    private static final String TEST_TOPIC = "KAFKA_TEST";
    private static final long TIME_WINDOW_SECONDS = 5L; //窗口大小设为5秒
    private static final long ADVANCED_BY_SECONDS = 1L; //前进间隔1秒

    public static void main(String[] args) throws InterruptedException {
        new TimeWindowTest().testHoppingTimeWindowWithSuppress();
    }

    public void testHoppingTimeWindowWithSuppress() throws InterruptedException {
        Properties props = configStreamProperties();
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> data = builder.stream(TEST_TOPIC);

        Instant initTime = Instant.now();

        data.groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofSeconds(TIME_WINDOW_SECONDS))
                        .advanceBy(Duration.ofSeconds(ADVANCED_BY_SECONDS))
                        .grace(Duration.ZERO))
                .count(Materialized.with(Serdes.String(), Serdes.Long()))
                .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
                .toStream()
                .filterNot(((key, value) -> this.isOldWindow(key, value, initTime))) //剔除太旧的时间窗口
                .foreach(this::dealWithTimeWindowAggrValue);

        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();

        Thread.currentThread().join();
    }

    private Properties configStreamProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-ljf-test");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOT_STRAP_SERVERS);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "500");//todo 默认值为30s，会导致30s才提交一次数据。
        return props;
    }

    private boolean isOldWindow(Windowed<String> windowKey, Long value, Instant initTime) {
        Instant windowEnd = windowKey.window().endTime();
        return windowEnd.isBefore(initTime);
    }

    private void dealWithTimeWindowAggrValue(Windowed<String> key, Long value) {
        Windowed<String> windowed = getReadableWindowed(key);
        System.out.println("处理聚合结果：key=" + windowed + ",value=" + value);
    }

    private Windowed<String> getReadableWindowed(Windowed<String> key) {
        return new Windowed<String>(key.key(), key.window()) {
            @Override
            public String toString() {
                String startTimeStr = toLocalTimeStr(Instant.ofEpochMilli(window().start()));
                String endTimeStr = toLocalTimeStr(Instant.ofEpochMilli(window().end()));
                return "[" + key() + "@" + startTimeStr + "/" + endTimeStr + "]";
            }
        };
    }

    private static String toLocalTimeStr(Instant i) {
        return i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString();
    }
}
