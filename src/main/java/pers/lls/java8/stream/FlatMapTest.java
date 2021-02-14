package pers.lls.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class FlatMapTest {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World"};
        List<Stream<String>> collect = Arrays.asList(strings).stream().
                map(str -> str.split("")).
                map(str -> Arrays.asList(strings).stream()).
                collect(Collectors.toList());

        List<String> collect1 = Arrays.asList(strings).stream().
                map(str -> str.split("")).
                flatMap(str -> Arrays.asList(strings).stream())
                .collect(Collectors.toList());
    }
}
