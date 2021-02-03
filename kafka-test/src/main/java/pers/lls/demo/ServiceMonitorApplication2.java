package pers.lls.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.WindowStore;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ServiceMonitorApplication2 {
    private static final int TEMPERATURE_WINDOW_SIZE = 5;
    private static final long ADVANCED_BY_SECONDS = 1L; //前进间隔1秒
    private static final long TIME_WINDOW_SECONDS = 5L; //窗口大小设为5秒

    private static final ObjectMapper mapper = new ObjectMapper();
    DateTimeFormatter formatter =
            DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                    .withLocale( Locale.UK )
                    .withZone( ZoneId.systemDefault() );

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
//            private static final long serialVersionUID = 1L;
//            // 反序列化时调用
//            @Override
//            public String nameForSetterMethod(MapperConfig<?> config,
//                                              AnnotatedMethod method, String defaultName) {
//                return method.getName();
//            }
//            // 序列化时调用
//            @Override
//            public String nameForGetterMethod(MapperConfig<?> config,
//                                              AnnotatedMethod method, String defaultName) {
//                return method.getName();
//            }
//        });
    }

//    private boolean isOldWindow(Windowed<String> windowKey, Long value, Instant initTime) {
//        Instant windowEnd = windowKey.window().endTime();
//        return windowEnd.isBefore(initTime);
//    }

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

    private void hello(){
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-serviceMonitor");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.1.11.53:9192");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        props.put(ConsumerConfig.GROUP_ID_CONFIG, "sm"+System.currentTimeMillis());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);

        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("KAFKA_TEST");
        KStream<String, ServiceMonitor> guijiKStream = source.flatMapValues(value -> {
            List<ServiceMonitor> results = Lists.newArrayList();
            try {
                Map map = mapper.readValue(value, Map.class);
                List<Map> metrics =(List) map.get("metrics");
                for(Map item : metrics){
                    ServiceMonitor serviceMonitor = new ServiceMonitor();
                    serviceMonitor.setMetric((String)item.get("metric"));
                    serviceMonitor.setTimestamp((Long)item.get("timestamp"));
                    serviceMonitor.setValue((double) (int) item.get("value"));
                    serviceMonitor.setTags((Map)item.get("tags"));
                    results.add(serviceMonitor);
                }
                return results;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Lists.newArrayList();
        });

//        guijiKStream.print(Printed.toSysOut());


//
//        .count(Materialized.with(Serdes.String(), Serdes.Long()))
//                .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
//                .toStream()

//        KGroupedStream<String, String> KGroupedStream = guijiKStream.map((key, value) -> new KeyValue<>(value.getMetric(),value.getMetric()))
//                .groupByKey();
//        KGroupedStream.count(Materialized.with(Serdes.String(), Serdes.Long())).toStream().print(Printed.toSysOut());

        Instant initTime = Instant.now();
        //序列化和反序列化
        final Serde<Statistics> statisticsSerde =SerdesFactory.serdFrom(Statistics.class);


        guijiKStream
                .map((key, value) -> {
                    try {
                        return new KeyValue<>(value.getMetric(), mapper.writeValueAsString(value));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofSeconds(TIME_WINDOW_SECONDS))
                        .advanceBy(Duration.ofSeconds(ADVANCED_BY_SECONDS))
                        .grace(Duration.ZERO))
                .aggregate(
                        new Initializer<Statistics>() {
                            @Override
                            public Statistics apply() {
                                Statistics avgAndSum = new Statistics(0L, 0L, 0L);
                                return avgAndSum;
                            }
                        },
                        new Aggregator<String, String, Statistics>() {
                            @Override
                            public Statistics apply(String aggKey, String newValue, Statistics aggValue) {
                                //topic中的消息格式为{"temp":19, "humidity": 25}
                                System.out.println("aggKey:" + aggKey + ",  newValue:" + newValue + ", aggKey:" + aggValue);
                                Long newValueLong = null;
                                try {
//                                    JSONObject json = JSON.parseObject(newValue);
                                    //newValueLong = json.getLong("temp");
                                    newValueLong = 0l;
                                } catch (ClassCastException ex) {
                                    newValueLong = Long.valueOf(newValue);
                                }
                                aggValue.setCount(aggValue.getCount() + 1);
                                aggValue.setSum(aggValue.getSum() + newValueLong);
                                aggValue.setAvg(0l);
                                return aggValue;
                            }
                        },
                        Materialized.<String, Statistics, WindowStore<Bytes, byte[]>>as("time-windowed-aggregated-temp-stream-store")
                                .withValueSerde(statisticsSerde)
                )
//                .count(Materialized.with(Serdes.String(), Serdes.Long()))
                .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
                .toStream()
                .filterNot(((key, value) -> this.isOldWindow(key, value, initTime)))
                .foreach(this::dealWithTimeWindowAggrValue); //剔除太旧的时间窗口;


//        WindowedSerializer<String> windowedSerializer = new WindowedSerializer<>(Serdes.String().serializer());
//        WindowedDeserializer<String> windowedDeserializer = new WindowedDeserializer<>(Serdes.String().deserializer(), TEMPERATURE_WINDOW_SIZE);
//        Serde<Windowed<String>> windowedSerde = Serdes.serdeFrom(windowedSerializer, windowedDeserializer);

//        aggregate.toStream().to("reulst-temp-stat", Produced.with(windowedSerde, statisticsSerde));


        final KafkaStreams streams = new KafkaStreams(builder.build(), props);
        final CountDownLatch latch = new CountDownLatch(1);


        Runtime.getRuntime().addShutdownHook(new Thread("streams-temperature-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);

    }

    private void dealWithTimeWindowAggrValue(Windowed<String> key, Statistics value) {
        Windowed<String> windowed = getReadableWindowed(key);
        System.out.println("处理聚合结果：key=" + windowed + ",value=" + value);
    }

    private boolean isOldWindow(Windowed<String> windowKey, Statistics value, Instant initTime) {
        Instant windowEnd = windowKey.window().endTime();
        return windowEnd.isBefore(initTime);
    }

    public static void main(final String[] args) throws Exception {
         new ServiceMonitorApplication2().hello();
    }



}