package pers.lls.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

/**
 * Hello world!
 */
public class Sender implements Runnable {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    public Sender(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.11.53:9192");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(props);
        this.topic = topicName;
    }

    @Override
    public void run() {
        int messageNo = 1;
        try {
            for (; ; ) {
                Thread.sleep(2000);
                String messageStr = "{\n" +
                        "    \"metrics\": [\n" +
                        "        {\n" +
                        "            \"metric\": \"service.success_rate\",\n" +
                        "            \"tags\": {\n" +
                        "                \"product\": \"store-metric\",\n" +
                        "                \"method\": \"queryWithAlign\",\n" +
                        "                \"module\": \"reader\",\n" +
                        "                \"interface\": \"uyun.indian.reader.api.ReaderService\",\n" +
                        "                \"pkg\": \"monitorService\"\n" +
                        "            },\n" +
                        "            \"timestamp\": 1611126655000,\n" +
                        "            \"value\": 0\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"node\": \"10.1.240.112\"\n" +
                        "}";

                producer.send(new ProducerRecord<String, String>(topic, "Message", messageStr));
                //生产了100条就打印
                System.out.println("发送的信息:" + messageStr);
                //生产1000条就退出
                if (messageNo % 1000 == 0) {
                    System.out.println("成功发送了" + messageNo + "条");
                    break;
                }
                messageNo++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    public static void main(String args[]) {
        Sender test = new Sender("KAFKA_TEST");
        Thread thread = new Thread(test);
        thread.start();
    }
}
