package com.learning._8.stream;

import com.mongodb.assertions.Assertions;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIs {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        // 1.0 Intermediate Operations:

        // 1.1 map(Function mapper):
        List<String> vListOfStrings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> vListOfIntegers = vListOfStrings.stream()
                .map(Integer::valueOf)
                .toList();
        System.out.println(vListOfIntegers);   //[1, 2, 3, 4, 5]

        // 1.2 flatMap(Function mapper):
        List<List<Integer>> vListOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattenedList = vListOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(flattenedList);    //[1, 2, 3, 4, 5, 6, 7, 8]


        // 1.3 eek(Consumer action):
        /*
        - Java Stream peek() method returns a new Stream consisting of all the elements from the original Stream after applying a given Consumer action.

        - Stream peek() method is an intermediate operation.
        - It returns a Stream consisting of the elements of current stream.
        - It additionally perform the provided action on each element as elements.

        - For parallel stream pipelines, the action may be called at whatever time and in whatever thread the element is made available by the upstream operation.
        - If the action modifies shared state, it is itself responsible for providing the required synchronization.
        - peek() exists mainly to support debugging, where we want to see the elements as they flow past a certain point in a pipeline.
         */

        // Stream.peek() without terminal operation
        List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5);
        iList.stream()
                .peek( System.out::println );   //prints nothing

        // Stream.peek() with terminal operation
        List<Integer> newList = iList.stream()
                .peek(System.out::print)
                .collect(Collectors.toList());
        // System.out.println(newList);
        // 12345


        // 1.4 skip():
        // Stream<T> skip(long n)
        /*
        - Stream skip(n) method is used to skip the first 'n' elements from the given Stream.

        - The skip() method returns a new Stream consisting of the remaining elements of the original Stream, after the specified n elements have been discarded in the encounter order.

        - Stream skip() method is stateful intermediate operation.
                Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements.
        - Returns a stream consisting of the remaining elements of the stream after discarding the first n elements of the stream.
        - If the stream contains fewer than n elements then an empty stream will be returned.

        - Generally skip() is a cheap operation, it can be quite expensive on ordered parallel pipelines, especially for large values of n.
        - Using an unordered stream source (such as generate(Supplier)) or removing the ordering constraint with BaseStream.unordered() may result in significant speedups of skip() in parallel pipelines.
        - skip() skips the first n elements in the encounter order.
         */
        Supplier<Stream<Integer>> evenNumInfiniteStream =  () -> Stream.iterate(0, n -> n + 2);
        List<Integer> newListSkip = evenNumInfiniteStream.get()
                .skip(5)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(newListSkip);
        // [10, 12, 14, 16, 18, 20, 22, 24, 26, 28]

        // 1.5 limit():
        // Stream<T> limit(long maxSize)  : [0, maxSize-1]
        /*
        - Stream limit(n) is used to retrieve a number of elements from the Stream while the count must not be greater than n.
        - The limit() method returns a new Stream consisting of the elements of the given stream, truncated to be no longer than maxSize in length.

        - Stream.limit() method is short-circuiting intermediate operation.
                An intermediate operation is short-circuiting if, when presented with infinite input, it may produce a finite stream as a result.
                Please note that a terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time.
        - It returns a stream consisting of the maximum elements, no longer than given size in length, of current stream.
         */
        List<Integer> newListLimit = evenNumInfiniteStream.get()
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(newListLimit);
        // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]


        // 1.6 sorted():
        // 1.6.1 Stream<T> sorted() – Provides the default sorting [natural Order: 1<2<3 or a<b<c]
        // 1.6.2 Stream<T> sorted(Comparator) – Sorting based on the provided comparator.

        /*
        - sorted() is a stateful intermediate operation that returns a new Stream.
        - It returns a stream consisting of the elements of this stream, sorted according to the natural order.
        - If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
        - For ordered streams, the sort is stable.
        - For unordered streams, no stability guarantees are made.
         */
        System.out.println("sorted() :");
        integerList.stream()
                .sorted().forEach(x -> System.out.print(x + " "));

        System.out.println("\nnaturalOrder() :");
        integerList.stream()
                .sorted(Comparator.naturalOrder()).forEach(x -> System.out.print(x + " "));

        System.out.println("\nsorted(Comparator.reverseOrder()) :");
        integerList.stream()
                .sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));

        System.out.println();

        // 1.7 filter():
        // Stream<T> filter(Predicate<? super T> condition)
        /*
        - filter() is a intermediate Stream operation.
        - It returns a Stream consisting of the elements of the given stream that match the given predicate.
        - The filter() argument should be stateless predicate which is applied to each element in the stream to determine if it should be included or not.
        - Predicate is a functional interface. So, we can also pass lambda expression also.
        - It returns a new Stream so we can use other operations applicable to any stream.
         */
        integerList.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 1.8 distinct()
        // Stream<T> distinct()
        /*
        - The distinct() returns the distinct elements from the given stream.
        - **For checking the equality of the stream elements, the equals() method is used.

        - The distinct() guarantees the ordering for the streams backed by an ordered collection.
                The element appearing first in the encounter order is preserved for ordered streams.
                For unordered streams, no stability guarantees are made.
         */

        Collection<String> stringList = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        List<String> distinctChars = stringList.stream()
                .distinct()
                .toList();



        // 2.0 Terminal Operations:

        // 2.1 findAny() :
        // Optional<T> findAny()
        /*
        - The Stream.findAny() returns an Optional describing any element of the specified stream if Stream is non-empty.
        It returns an empty Optional if the stream is empty.

        - In non-parallel streams, findAny() will return the first element in most cases, but this behavior is not guaranteed.
        - The Stream.findAny() method has been introduced for performance gain in the case of parallel streams, only.

        - The findAny() method is a terminal short-circuiting operation.
        - The findAny() method returns an Optional.
        - The Optional contains the value as any element of the given stream, if Stream is non-empty.
        - The returned element is the first element in most cases.
        - The Optional contains the empty value, if Stream is empty.
        - If the element selected is null, NullPointerException is thrown.
        - For all the sequential and parallel streams, it may return any element.
        - The behavior of findAny() does not change by the parallelism of the Stream.
        - Similarly, there is no guaranteed behavioral difference in case of a stream has a defined encounter order or has no encounter order at all.
         */

        Optional<Object> optional = Stream.empty().findAny();
        Assertions.assertTrue(optional.isEmpty()); // true

        Optional<String> optional1 = Stream.of("one", "two", "three", "four").findAny();
        Assertions.assertTrue(optional1.isPresent()); // true

        Optional<String> optional2 = Stream.of("one", "two", "three", "four").parallel().findAny();
        Assertions.assertTrue(optional2.isPresent());


        // Difference between findFirst() vs findAny()
        // 1. In non-parallel streams, findFirst() and findAny(), both may return the first element of the Stream in most cases.
        // But findAny() does not offer any guarantee of this behavior.
        // 2. Use findAny() to get any element from any parallel stream in a faster time. Else we can always use findFirst() in most cases.


        // 2.2 findFirst()
        // Optional<T> findFirst();
        /*
        - The findAny() method is a terminal short-circuiting operation.
        - The findFirst() method returns an Optional.
        - The Optional contains the value as the first element of the given stream, if the stream is non-empty.
        - The Optional contains the empty value, if Stream is empty.
        - If the element selected is null, NullPointerException is thrown.
        - If Stream has defined encounter order, the findFirst() returns first element in encounter order.
        - If Stream has no encounter order, the findFirst() may return any element.
        - The above behavior is valid for all sequential and parallel streams. The behavior of findFirst() does not change by the parallelism of the Stream.
         */
        Stream.of("one", "two", "three", "four")
                .findFirst()
                .ifPresent(System.out::println);   // Prints 'one'

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Optional<String> firstWordStartingWithC = words.stream()
                .filter(word -> word.startsWith("c"))
                .findFirst();
        firstWordStartingWithC.ifPresent(word ->
                System.out.println("First word starting with 'c': " + word));  // Prints 'cherry'


        // 2.3 noneMatch(predicate) :
        // boolean noneMatch(Predicate<? super T> predicate)
        /*
        - Java Stream noneMatch() method is a short-circuiting terminal operation.
        - The noneMatch() is used to check that Stream does not contain any element matching the provided Predicate.

        * The noneMatch() returns:
        true – if no element in the stream matches the given predicate, or the stream is empty.
        false – if at least one element matches the given predicate.
        Here predicate a non-interfering and stateless predicate to apply to elements of the stream.

        - It is short-circuiting operation.
        - A terminal operation is short-circuiting if, when presented with infinite input, it may terminate in finite time.
         */
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        boolean match = stream.noneMatch( s -> s.contains("\\d+") );
        System.out.println(match); // true


        // 2.4 allMatch() :
        // boolean allMatch(Predicate<? super T> predicate)
        /*
        - Java Stream allMatch() is a short-circuiting terminal operation that is used to check if all the elements in the stream satisfy the provided predicate.

        - It is a short-circuiting terminal operation.
        - It returns whether all elements of this stream match the provided predicate.
        - May not evaluate the predicate on all elements if not necessary for determining the result.
        * Method returns true if all stream elements match the given predicate, else method returns false.
        - If the stream is empty then true is returned and the predicate is not evaluated.
        - The difference between allMatch() and anyMatch() is that anyMatch() returns true if any of the elements in a stream matches the given predicate. When using allMatch(), all the elements must match the given predicate.
         */
        boolean match1 = Stream.of("one", "two", "three", "four")
                .allMatch( s -> s.contains("\\d+") );
        System.out.println(match1); // false

        // 2.5 anyMatch(predicate) :
        // boolean anyMatch(Predicate<? super T> predicate)
        /*
        - Here predicate a non-interfering, stateless Predicate to apply to elements of the stream.
        - The anyMatch() method returns true if at least one element satisfies the condition provided by predicate, else false.
         */
        boolean match2 = Stream.of("one", "two", "three", "four")
                .anyMatch(s -> s.contains("four"));


        // 2.6 min()
        // Optional<T> min(Comparator<? super T> comparator)
        /*
        - This is a terminal operation. So stream cannot be used after this method is executed.
        - Returns the minimum element of this stream according to the provided Comparator.
        - This is a special case of a stream reduction.

        - The method argument shall be a non-interfering, stateless Comparator.
        - The method returns an Optional describing the smallest element of this stream, or an empty Optional if the stream is empty.
        - It may throw NullPointerException if the smallest element is null.
         */

        Optional<Integer> minNumber = integerList.stream().min(Integer::compareTo);
        System.out.println("minNumber: " + minNumber.get());


        // 2.7 max()
        // 2.7.1 Optional<T> max(Comparator<? super T> comparator)
        /*
        - The max() method is a terminal operation. So the Stream cannot be used after this method has been executed.
        - It returns the maximum/largest element of this stream according to the provided Comparator.
        - This is a special case of a stream reduction.

        - The method argument shall be a non-interfering, stateless Comparator.
        - The method returns an Optional describing the maximum element of this stream, or an empty Optional if the stream is empty.
        - It may throw NullPointerException if the maximum element is null.
         */
        OptionalInt maxIntValue = IntStream.of(4, 2, 7, 0, 1).max();

        // 2.7.1
        Optional<Integer> maxNumber = integerList.stream().max(Integer::compareTo);
        System.out.println("maxNumber: " + maxNumber.get());


        List<Integer> numbers = Arrays.asList(2, 4, 7, 1, 0);

        // 2.8 reduce() :
        // 2.8.1 T reduce(T identity, BinaryOperator<T> accumulator)
        // 2.8.2 Optional<T> reduce(BinaryOperator<T> accumulator)
        // 2.8.3 <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

        /*
        - Need for a fold implementation in the Stream API.
        - Folding is a very useful and common functional programming feature. It operates on a collection of elements to return a single result using some sort of operation.

        accumulator – an associative, non-interfering, stateless function for combining two values
        combiner - It sums the results of the available accumulators to produce the final result.
         */

        // 2.8.1
        // ****Note: The sum(), average(), max() and min() operations of the Stream API are reduction variations.
        IntStream intStream = IntStream.of(11, 22, 33, 44, 55);
        int sum0 = intStream.reduce(0, (left, right) -> left + right);
        // or
        // intStream.sum();

        // int max = intStream.reduce(0, Integer::max); // intStream.max();
        // int min = intStream.reduce(0, Integer::min); // intStream.min();

        int even_sum = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (sum, i) -> sum + i);
        //Here, sum variable is assigned 0 as initial value and i is added to it.
        System.out.println("reduce: " + even_sum);

        // 2.8.2
        List<String> langs = List.of("Java", "Python", "JavaScript");
        Optional longest = langs.stream().reduce((s1, s2) -> (s1.length() > s2.length()) ? s1 : s2);
        longest.ifPresent(System.out::println); //JavaScript

        // 2.8.3
        String string = "Our Mathematical Universe: My Quest for the Ultimate Nature of Reality";
        List<String> wordList = List.of(string.split(" "));

        int length = wordList
                .stream()
                .reduce(
                        0,
                        (parLength, word) -> parLength + word.length(),
                        (parLength, otherParLength) -> parLength + otherParLength
                );
        System.out.println("The sum length of all the words in the paragraph is " + length );


        // 2.9 collect() :
        // 2.9.1 collect(Collector collector)
        // 2.9.2 collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
        Set<Integer> square_set = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println("\nSet: " + square_set);


        // 2.10 forEach() :
        // void forEach(Consumer action) :
        numbers.stream().map(x -> x * x).forEach(System.out::println);


    }
}
