package com.learning._8.stream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {

        /*
         * Stream Creation:
         * Stream<T> : Generic Interface
         * */
        //Empty Stream
        Stream<String> streamEmpty = Stream.empty();
        //Stream of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> collStream = collection.stream();

        //Array Stream
        Stream<String> arrayStream = Stream.of("a", "b", "c");

        String[] array = collection.toArray(new String[0]);
        Stream<String> arrayFullStream = Arrays.stream(array);
        Stream<String> arrayPartStream = Arrays.stream(array, 1, 3);

        //Stream.builder()
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        /*
        Stream.generate():
        generate() method accepts Supplier<T> for element generation.
        As the resulting stream is infinite, developer must specify the desired size, or it will until reaches memory limit.
        */
        //create sequence of 4 strings with value 'element'
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(4);

        /*
        stream.iterate():
        seed(1st parameter of iterate()): 1st element of resulting stream
        While creating every following element, specified function is applied to the previous element.
        */
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(10);

        /*
        Stream of Primitives:
        IntStream, LongStream, DoubleStream : Interfaces
        Using these interfaces alleviates unnecessary autoboxing, which allows increased productivity

        range(int startInclusive, int endExclusive): ordered stream
        rangeClosed(int startInclusive, int endInclusive) : ordered stream
        */
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        //Stream of String
        IntStream streamOfChars = "abc".chars();

        //Break a String into sub-strings according to specified RegEx
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

        /*
        Stream of File:
        Files allows us to generate a Stream<String> of a text file through the "lines()" method.
        Every line of text becomes an element of the stream
        */

        try {
            Path path = Paths.get("C:\\Users");
            Stream<String> stringStream = Files.lines(path);
            Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
