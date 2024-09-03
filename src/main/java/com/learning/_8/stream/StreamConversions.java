package com.learning._8.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamConversions {

    public static void main(String[] args) {

        /**
         * Stream and Array
         */

        // 1. Array To Stream
        // The primary method to convert an array to a stream of elements is Arrays.stream().
        // It is an overloaded method.

        //Stream<T> stream(T[] array) : returns a sequential Stream with the specified array as its source.
        //Stream<T> stream(T[] array, int start, int end) : returns a sequential Stream of array items from index positions start (inclusive) to end (exclusive).

        int[] primitiveArray = {0,1,2,3,4};
        IntStream intStream = Arrays.stream(primitiveArray);

        Stream<Integer> integerStream = Arrays.stream(primitiveArray)
                .boxed();

        String[] stringArray = {"a", "b", "c", "d", "e"};
        Stream<String> strStream = Arrays.stream(stringArray);


        // 2. Stream To Array
        // The primary method for converting a stream to an array is Stream.toArray().
        // It is also an overloaded method.

        // Object[] toArray() : returns an array containing the elements of a specified stream. By default, the return type of this method is Object[].
        // T[] toArray(IntFunction<T[]> generator) : returns an array containing the elements of this stream, using the provided generator function.
        // The generator produces a new array of the desired type and the provided length.

        IntStream intStream1 = Arrays.stream(new int[]{1,2,3});
        int[] primitiveArray1 = intStream1.toArray();

        Stream<Integer> integerStream1 = Arrays.stream(new Integer[]{1,2,3});
        int[] primitiveArray2 = integerStream1.mapToInt(i -> i).toArray();

        Stream<String> strStream1 = Arrays.stream(new String[]{"abc", "xyz"});
        String[] stringArray1 = strStream.toArray(String[]::new);


        // 3. Convert Iterable or Iterator to Stream

        // 3.1. Converting Iterable to Stream
        // To convert, we will use iterable.spliterator() method to get the Spliterator reference, which is then used to get
        // the Stream using StreamSupport.stream(spliterator, isParallel) method.

        // Iterable
        Iterable<String> iterable = Arrays.asList("a", "b", "c");
        // Iterable -> Stream
        // false means sequential stream
        Stream<String> stream = StreamSupport.stream(iterable.spliterator(), false);


        // 3.2. Converting Iterator to Stream – Java 8
        // The only difference is that the Iterator interface has no spliterator() method so we need to use
        // Spliterators.spliteratorUnknownSize() method to get the spliterator. Rest everything is same.

        // Iterator
        Iterator<String> iterator = Arrays.asList("a", "b", "c").listIterator();
        //Extra step to get Spliterator
        Spliterator<String> splitItr = Spliterators
                .spliteratorUnknownSize(iterator, Spliterator.ORDERED);
        // Iterator -> Stream
        Stream<String> stream1 = StreamSupport.stream(splitItr, false);


        // 3.3. Converting Iterator to Stream – Java 9
        // Iterator
        Iterator<String> iterator1 = Arrays.asList("a", "b", "c")
                .listIterator();
        Stream<String> stream2 = Stream.generate(() -> null)
                .takeWhile(x -> iterator.hasNext())
                .map(n -> iterator.next());

    }
}
