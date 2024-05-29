package com.learning._8.stream;

import org.javatuples.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamCollectors {

    public static void main(String[] args) {

        /**
         * List collectors
         */

        Supplier<Stream<String>> tokenStreamSup = () -> Stream.of("A", "B", "C", "D");

        List<String> tokenList = tokenStreamSup.get().toList();

        List<String> unmodTokenList = tokenStreamSup.get()
                .collect(Collectors.toUnmodifiableList());

        List<String> tokenList1 = tokenStreamSup.get()
                .collect(Collectors.toCollection(LinkedList::new));

        // Primitive Stream -> List
        IntStream infiniteNumberStream = IntStream.iterate(1, i -> i+1);
        List<Integer> integerlist = infiniteNumberStream.limit(10)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> listOfIntegers = IntStream.of(1,2,3,4,5)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        // Primitive Stream -> Array
        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();


        /**
         * Java Collectors.toMap(): Collecting Stream Items into Map
         */

        /**
         * 2. Convert Stream to Map (without Duplicate Keys)
         */
        Stream<Person> stream = Stream.of(
                new Person(1, "P1", "", 12),
                new Person(2, "P2", "", 13),
                new Person(3, "P3", "", 11)
        );

        // Map<Long, String> mapWithValue = stream.collect(Collectors.toMap(Person::id, Person::firstName));
        // {1=P1, 2=P2, 3=P3}
        Map<Long, Person> map = stream
                .collect(Collectors.toMap(
                        Person::id,
                        Function.identity()));
        // {1=Person[id=1, firstName=P1, lastName=, age=12], 2=Person[id=2, firstName=P2, lastName=, age=13], 3=Person[id=3, firstName=P3, lastName=, age=11]}

        /**
         * 3. Convert Stream to Map (with Duplicate Keys)
         */
        Supplier<Stream<Person>> streamWithDuplicatesSup = () -> Stream.of(
                new Person(1, "P1", "", 12),
                new Person(2, "P2", "", 13),
                new Person(3, "P3-1", "", 11),
                new Person(3, "P3-2", "", 11)
        );

        // 3.1. Collecting Stream to Map of Lists
        // Collectors.groupingBy() to collect elements in Map<key, List<value>> format.

        Map<Long, List<Person>> mapWithList = streamWithDuplicatesSup.get()
                .collect(
                        groupingBy(Person::id));
        // {1=[Person[id=1, firstName=P1, lastName=, age=12]], 2=[Person[id=2, firstName=P2, lastName=, age=13]], 3=[Person[id=3, firstName=P3-1, lastName=, age=11], Person[id=3, firstName=P3-2, lastName=, age=11]]}

        Map<Long, List<String>> mapWithGroupedValues = streamWithDuplicatesSup.get()
                .collect(
                        groupingBy(Person::id,
                                Collectors.mapping(Person::firstName, Collectors.toList())));
        // System.out.println(mapWithGroupedValues); // {1=[P1], 2=[P2], 3=[P3-1, P3-2]}

        // 3.2. Collecting Stream to Map with Discarding Duplicate Values
        Map<Long, Person> mapWithGrouping = streamWithDuplicatesSup.get()
                .collect(Collectors.toMap(
                        Person::id,
                        Function.identity(),
                        (oldValue, newValue) -> newValue));
        System.out.println(mapWithGrouping);
        // {1=Person[id=1, firstName=P1, lastName=, age=12], 2=Person[id=2, firstName=P2, lastName=, age=13],
        // 3=Person[id=3, firstName=P3-2, lastName=, age=11]}


        /**
         * 4. Maintaining Insertion Order or Sorting of keys
         */
        // To maintain the order of key-value pairs in which they are inserted into the Map.
        // The LinkedHashMap maintains such insertion order so we can use it to collect the Stream items.
        LinkedHashMap<Long, String> mapWithValueInInsertionOrder = streamWithDuplicatesSup.get()
                .collect(Collectors.toMap(
                        Person::id,
                        Person::firstName,
                        (o, n) -> n,
                        LinkedHashMap::new));
        // {1=P1, 2=P2, 3=P3-2}

        // To apply and maintain the sorting order in the Map keys, we can use the TreeMap.
        TreeMap<Long, String> mapWithSortedKeys = streamWithDuplicatesSup.get()
                .collect(Collectors.toMap(
                        Person::id,
                        Person::firstName,
                        (o, n) -> n,
                        TreeMap::new));
        // {1=P1, 2=P2, 3=P3-2}


        /**
         * Collecting Stream Elements into Immutable Collection
         */

        // 1. Using Collectors.collectingAndThen() – Java 8
        Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList));
        // or
        List<Integer> mutableList = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .collect(Collectors.toList());
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);


        // 2. Using Collectors.toUnmodifiableList() – Java 10
        var unmodifiableList1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toUnmodifiableList());

        var unmodifiableSet = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toUnmodifiableSet());

        var unmodifiableMap = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toUnmodifiableMap(i -> i, i -> i * i));


        // 3. Using Stream.toList() – Java 16
        var unmodifiableList2 = Stream.of(1, 2, 3, 4, 5)
                .toList();


        /**
         * Java 8 Stream – Collectors GroupingBy
         */
        // 1. Collectors.groupingBy() Method
        // Stream -> groupingBy() -> Map of elements after applying ‘group by’ operation
        // 1.1 Syntax:
        // groupingBy(classifier)
        // groupingBy(classifier, collector)
        // groupingBy(classifier, supplier, collector)

        // classifier: maps input elements to map keys
        // collector: is the downstream reduction function. By default, Collectors.toList() is used which causes the grouped elements into a List.
        // supplier: provides a new empty Map into which the results will be inserted. By default, HashMap::new is used.
        // We can use other maps such as TreeMap, LinkedHashMap or ConcurrentMap to insert additional behavior in the grouping process such as sorting.

        // 1.2. Using groupingByConcurrent() for Parallel Processing
        // groupingByConcurrent(classifier)
        // groupingByConcurrent(classifier, collector)
        // groupingByConcurrent(classifier, supplier, collector)

        // 2. Examples

        List<User> users = List.of(
                new User(1, "Alex", 100d, new Department(1, "HR")),
                new User(2, "Brian", 200d, new Department(1, "HR")),
                new User(3, "Charles", 900d, new Department(2, "Finance")),
                new User(4, "David", 200d, new Department(2, "Finance")),
                new User(5, "Edward", 200d, new Department(2, "Finance")),
                new User(6, "Frank", 800d, new Department(3, "ADMIN")),
                new User(7, "George", 900d, new Department(3, "ADMIN"))
        );

        // 2.1. Grouping By a Simple Condition
        // Grouping all persons by department
        Map<Department, List<User>> map1 = users.stream().collect(groupingBy(User::department));
        System.out.println(map1);
        // {
        //	Department[id=2, name=Finance]=[
        //	Person[id=3, ...],
        //	Person[id=4, ...],
        //	Person[id=5, ...],
        //
        //	Department[id=3, name=ADMIN]=[
        //	Person[id=6, ...],
        //	Person[id=7, ...],
        //
        //	Department[id=1, name=HR]=[
        //	Person[id=1, ...],
        //	Person[id=2, ...]
        //}

        Map<Department, List<Integer>> map2 = users.stream()
                .collect(groupingBy(
                        User::department,
                        Collectors.mapping(
                                User::id,
                                Collectors.toList())));

        System.out.println(map2);
        // {
        // Department[id=2, name=Finance]=[3, 4, 5],
        // Department[id=3, name=ADMIN]=[6, 7],
        // Department[id=1, name=HR]=[1, 2]
        // }

        // 2.2. Grouping by Complex Condition
        // There may be cases when we have to apply a complex condition for grouping. In this case,
        // the Map can represent the condition using a Java tuple and then group the matching elements as a List in Map value.
        // Group by distinct department and salary pairs
        Map<Object, List<Integer>> map3 = users.stream()
                .collect(groupingBy(
                        user -> new Pair<>(user.salary(), user.department()),
                        Collectors.mapping(
                                User::id,
                                Collectors.toList())));

        System.out.println(map3);
        // {
        //	[900.0, Department[id=3, name=ADMIN]]=[7],
        //	[800.0, Department[id=3, name=ADMIN]]=[6],
        //	[200.0, Department[id=2, name=Finance]]=[4, 5],
        //	[900.0, Department[id=2, name=Finance]]=[3],
        //	[200.0, Department[id=1, name=HR]]=[2],
        //	[100.0, Department[id=1, name=HR]]=[1]
        // }

        // 2.3. Grouping with Counting
        // We can also aggregate the values by performing other operations such as counting(), averaging() summing() etc.
        // This helps in getting the reduction operation on Map values to produce a single value.
        // Count persons by department
        Map<Department, Long> map4 = users.stream()
                .collect(groupingBy(
                        User::department,
                        Collectors.counting()));

        System.out.println(map4);
        // {
        //	Department[id=2, name=Finance]=3,
        //	Department[id=3, name=ADMIN]=2,
        //	Department[id=1, name=HR]=2
        // }

        // Count persons with same salary
        Map<Double, Long> map5 = users.stream()
                .collect(groupingBy(
                        User::salary,
                        Collectors.counting()));

        System.out.println(map5);
        // {800.0=1, 200.0=3, 100.0=1, 900.0=2}


        // 2.4. Grouping with Average
        // Average salary in each department
        Map<Department, Double> map6 = users.stream()
                .collect(groupingBy(
                        User::department,
                        Collectors.averagingDouble(User::salary)));

        System.out.println(map6);
        // {
        // Department[id=2, name=Finance]=433.3333333333333,
        // Department[id=3, name=ADMIN]=850.0,
        // Department[id=1, name=HR]=150.0
        // }

        // 2.5. Grouping with Max/Min
        // Max salaried person in each department
        Map<Department, Optional<User>> map7 = users.stream()
                .collect(groupingBy(
                        User::department,
                        Collectors.maxBy(Comparator.comparingDouble(User::salary))));

        System.out.println(map7);
        // {
        //	Department[id=2, name=Finance]=Optional[Person[id=3, name=Charles, salary=900.0,...]],
        //	Department[id=3, name=ADMIN]=Optional[Person[id=7, name=George, salary=900.0, ...]],
        //	Department[id=1, name=HR]=Optional[Person[id=2, name=Brian, salary=200.0, ...]]
        // }

        // 2.6. Grouping with Filtering

        // The Stream.filter() method filters out all the non-matching elements from the stream before passing it to the next operation.
        // This may not be the desired solution.

        // Filtering all persons with salary less than 300
        Map<Department, Long> map8 = users.stream()
                .filter(p -> p.salary() > 300d)
                .collect(groupingBy(
                        User::department,
                        Collectors.counting()));

        System.out.println(map8);
        // {
        //	Department[id=2, name=Finance]=1,
        //	Department[id=3, name=ADMIN]=2
        // }

        // we can use Collectors.filtering(predicate, collector) method that applies the filter while adding values in to Map.
        Map<Department, Long> map9 = users.stream()
                .collect(groupingBy(
                        User::department, Collectors.filtering(
                                p -> p.salary() > 300d,
                                Collectors.counting())));

        System.out.println(map9);
        // {
        //	Department[id=2, name=Finance]=1,
        //	Department[id=3, name=ADMIN]=2,
        //	Department[id=1, name=HR]=0
        // }

    }
}
