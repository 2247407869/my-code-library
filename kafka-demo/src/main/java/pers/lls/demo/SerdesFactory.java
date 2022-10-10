package pers.lls.demo;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

public class SerdesFactory {
    /**
     * @param <T> The class should have a constructor without any
     *        arguments and have setter and getter for every member variable
     * @param pojoClass POJO class.
     * @return Instance of {@link Serde}
     *
     * 序列化和反序列化能用方法，
     */
    public static <T> Serde<T> serdFrom(Class<T> pojoClass) {
        Map<String, Object> serdeProps = new HashMap<>();
        final Serializer<Statistics> statisticsSerializer = new GenericSerializer<>();
        serdeProps.put("JsonPOJOClass", pojoClass);
        statisticsSerializer.configure(serdeProps, false);

        final Deserializer<Statistics> statisticsDeserializer = new GenericDeserializer<>();
        serdeProps.put("JsonPOJOClass", pojoClass);
        statisticsDeserializer.configure(serdeProps, false);

        // return Serdes.serdeFrom(new GenericSerializer<T>(pojoClass), new GenericDeserializer<T>(pojoClass));
        return (Serde<T>) Serdes.serdeFrom(statisticsSerializer, statisticsDeserializer);
    }
}