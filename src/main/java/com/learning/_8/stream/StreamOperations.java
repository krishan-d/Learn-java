package com.learning._8.stream;

import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {
        /**
         * Append or Prepend Items to a Stream
         *
         * Learn to add items to a Java Stream. Remember that a Stream is not a data structure or collection that can store values.
         * To add items to an existing Stream, we need to :
         *
         * Create a new Stream with items to be added
         * Concatenate with the first stream to get a merged stream.
         */

        // 1. Concatenating Streams
        /*
        The Stream.concat(stream1, stream2) is used to merge two streams into one stream which consists of all the elements of both streams.

        The concat(s1, s2) method creates a lazily concatenated stream whose elements are all the elements of the s1 followed by all the elements of the s2.
        The resulting stream is ordered if both of the input streams are ordered.
        The resulting stream is parallel if either of the input streams is parallel.
         */

        // 2.1. Appending Items
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        //Append 5 and 6 to the stream
        Stream<Integer> appenededStream = Stream.concat(stream, Stream.of(5, 6));
        //Verify Stream
        appenededStream.forEach(System.out::print); //Prints 123456

        //Prepend 0 to the stream
        Stream<Integer> prependedStream = Stream.concat(Stream.of(0), stream);

        // Combining Streams without Duplicate Elements
        Stream<Integer> secondStream = Stream.of(5, 6);
        Stream<Integer> resultingStream = Stream.concat(stream, secondStream).distinct();


    }
}
