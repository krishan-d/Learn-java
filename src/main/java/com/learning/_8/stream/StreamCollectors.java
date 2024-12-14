package com.learning._8.stream;

//import com.learning.Interview.interfaceQue.A;
import com.learning._8.stream.model.*;
import com.learning._8.stream.repository.StudentRepository;
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
        // or
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
        /*
        Collector toMap(Function keyMapper, Function valueMapper)
        Collector toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)  // Java 12
        Collector toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)

        Returns: A collector which collects elements into Map

        Collector toConcurrentMap(Function keyMapper, Function valueMapper)
        Collector toConcurrentMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        Collector toConcurrentMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)

        Returns: a concurrent, unordered Collector which collects elements into a ConcurrentMap

        Params:
        keyMapper - mapping function to produce keys
        valueMapper - mapping function to produce values
        mergeFunction - a merge function, used to resolve collisions between values assosiated with the same key,
        as supplied to Map.merge(Object, Object, BiFunction)
        mapFactory - a supplier providing a new empty map into which the results will be inserted
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

        /*
        groupingBy(Function)
        groupingBy(Function calssifier, Collector downStream)
        groupingBy(Function calssifier, Supplier mapFactory, Collector downStream)

        calssifier : a calssifier function mapping input elements to keys
        mapFactory : a supplier providing the new empty Map into whichthe result will be inserted
        downStream : a collector implementing the downstream collector
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
        // {1=[Person[id=1, firstName=P1, lastName=, age=12]], 2=[Person[id=2, firstName=P2, lastName=, age=13]],
        // 3=[Person[id=3, firstName=P3-1, lastName=, age=11], Person[id=3, firstName=P3-2, lastName=, age=11]]}

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



        //------------------------------------------------------------------------------------------


        /*List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));*/

        List<Student> studentList = StudentRepository.getUnsortedStudentList();

        // 1.
        // Collectors.toList() :
        // It returns a Collector which collects all input elements into a new List.

        //Example : Collecting top 3 performing students into List
        List<Student> top3Students = studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .limit(3).collect(Collectors.toList());

        System.out.println(top3Students);

        // 2.
        // Collectors.toSet() :
        // It returns a Collector which collects all input elements into a new Set.

        // Collecting departments offered into Set.
        Set<String> departments = studentList.stream().map(Student::getSubject)
                .collect(Collectors.toSet());

        System.out.println(departments);

        // 3.
        // Collectors.toMap() :
        // This method returns a Collector which collects input elements into a Map whose keys and values are the result of applying mapping functions to input elements.

        /*
        Collector toMap(Function keyMapper, Function valueMapper)
        Collector toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        Collector toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)

        Returns: A collector which collects elements into Map

        Collector toConcurrentMap(Function keyMapper, Function valueMapper)
        Collector toConcurrentMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        Collector toConcurrentMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)

        Returns: a concurrent, unordered Collector which collects elements into a ConcurrentMap

        Params:
        keyMapper - mapping function to produce keys
        valueMapper - mapping function to produce values
        mergeFunction - a merge function, used to resolve collisions between values assosiated with the same key,
        as supplied to Map.merge(Object, Object, BiFunction)
        mapFactory - a supplier providing a new empty map into which the results will be inserted
         */

        // Example : Collecting name and percentage of each student into a Map
        Map<String, Double> namePercentageMap = studentList.stream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));

        System.out.println(namePercentageMap);

        // 4.
        // Collectors.toCollection() :

        // This method returns a Collector which collects all input elements into a new Collection.

        // Example : Collecting first 3 students into LinkedList
        LinkedList<Student> studentLinkedList = studentList.stream()
                .limit(3)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(studentLinkedList);

        // 5.
        // Collectors.joining() :
        // Collectors.joining(CharSequence delimiter)
        // Collectors.joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)

        // Params:
        // delimiter – the delimiter to be used between each element
        // prefix – the sequence of characters to be used at the beginning of the joined result
        // suffix – the sequence of characters to be used at the end of the joined result
        // Returns:
        // A Collector which concatenates CharSequence elements, separated by the specified delimiter, in encounter order

        // This method returns a Collector which concatenates input elements separated by the specified delimiter.

        // Example : Collecting the names of all students joined as a string
        String namesJoined = studentList.stream().map(Student::getName)
                .collect(Collectors.joining(", "));

        System.out.println(namesJoined);


        // 6.
        // Collectors.counting() :
        // It returns a Collector that counts number of input elements.

        // Example : Counting number of students.
        Long studentCount = studentList.stream()
                .collect(Collectors.counting());

        System.out.println(studentCount);

        // 7.
        // Collectors.maxBy(...) :
        // Returns a Collector that produces the maximal element according to a given Comparator, described as an Optional<T>.

        // Collectors.maxBy(Comparator comparator)
        // Params:
        // comparator – a Comparator for comparing elements
        // Returns:
        // a Collector that produces the maximal value

        // Example : Collecting highest percentage.
        Optional<Double> highPercentage = studentList.stream()
                .map(Student::getPercentage)
                .collect(Collectors.maxBy(Comparator.naturalOrder()));

        System.out.println(highPercentage);

        // 8.
        // Collectors.minBy(...) :
        // This method returns a Collector which collects smallest element in a stream according to supplied Comparator.

        // Collectors.minBy(Comparator comparator)
        // Params:
        // comparator – a Comparator for comparing elements
        // Returns:
        // a Collector that produces the minimal value

        // Example : Collecting lowest percentage.
        Optional<Double> lowPercentage = studentList.stream()
                .map(Student::getPercentage)
                .collect(Collectors.minBy(Comparator.naturalOrder()));

        System.out.println(lowPercentage);


        // 9.
        // summingInt(), summingLong(), summingDouble():

        // These methods returns a Collector which collects sum of all input elements.

        // Example : Collecting sum of percentages
        Double sumOfPercentages = studentList.stream()
                .collect(Collectors.summingDouble(Student::getPercentage));

        System.out.println(sumOfPercentages);


        // 10.
        // averagingInt(), averagingLong(), averagingDouble()
        // syntax : averagingDouble(ToDoubleFunction mapper)

        // These methods return a Collector which collects average of input elements.
        // Example : Collecting average percentage
        Double averagePercentage = studentList.stream()
                .collect(Collectors.averagingDouble(Student::getPercentage));

        System.out.println(averagePercentage);


        // 11.
        // summarizingInt(), summarizingLong(), summarizingDouble()

        // These methods return a special class called Int/Long/ DoubleSummaryStatistics which contain statistical information like sum, max, min, average etc of input elements.

        // Example : Extracting highest, lowest and average of percentage of students
        DoubleSummaryStatistics studentStats = studentList.stream()
                .collect(Collectors.summarizingDouble(Student::getPercentage));

        System.out.println("Highest Percentage : "+studentStats.getMax());
        System.out.println("Lowest Percentage : "+studentStats.getMin());
        System.out.println("Average Percentage : "+studentStats.getAverage());
//      System.out.println("Average Percentage : "+studentStats.getSum());


        // 12.
        // Collectors.groupingBy() :

        // This method groups the input elements according supplied classifier and returns the results in a Map.
        // Stream -> groupingBy() -> Map of elements after applying ‘group by’ operation

        // 1.1 Syntax:
        // groupingBy(classifier)
        // groupingBy(classifier, collector)
        // groupingBy(classifier, supplier, collector)

        // classifier: maps input elements to map keys
        // collector: is the downstream reduction function.
        //      By default, Collectors.toList() is used which causes the grouped elements into a List.
        // supplier: provides a new empty Map into which the results will be inserted.
        //      By default, HashMap::new is used.
        // We can use other maps such as TreeMap, LinkedHashMap or ConcurrentMap to insert additional behavior in the grouping process such as sorting.

        // 1.2. Using groupingByConcurrent() for Parallel Processing
        // groupingByConcurrent(classifier)
        // groupingByConcurrent(classifier, collector)
        // groupingByConcurrent(classifier, supplier, collector)

        // Example : Grouping the students by subject
        Map<String, List<Student>> studentsGroupedBySubject = studentList.stream()
                .collect(Collectors.groupingBy(Student::getSubject));

        System.out.println(studentsGroupedBySubject);


        // 13.
        // Collectors.partitioningBy() :

        // Syntex:
        // Collectors.partitioningBy(Predicate predicate)
        // Collectors.partitioningBy(Predicate predicate, Collector downstream)

        // Param:
        // predicate - a predicate used for classifying input elements
        // downstream - a Collector implementing the downstream reduction
        // Returns :
        // A Collector implementing the cascaded partitioning operation

        // This method partitions the input elements according to supplied Predicate and returns a Map<Boolean, List<T>>.
        // Under the true key, you will find elements which match given Predicate and under the false key,
        // you will find the elements which doesn’t match given Predicate.

        // Example : Partitioning the students who got above 80.0% from who don’t.
        Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));

        System.out.println(studentspartionedByPercentage);


        // 14.
        // Collectors.collectingAndThen() :

        // Syntex:
        // Collectors.collectingAndThen(Collector downstream, Function finisher)
        // Param :
        //      downstream - a Collector
        //      finisher - a function to be applied to the final result of downstream collector
        // Return : a collector

        // This is a special method which lets you to perform one more action on the result after collecting the result.

        // Example : Collecting first three students into List and making it unmodifiable
        List<Student> first3Students = studentList.stream()
                .limit(3)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        System.out.println(first3Students);


        // 15.
        // Collectors.reducing(BinaryOperator<T> op)
        // Collectors.reducing(T identity, BinaryOperator<T> op)
        // Collectors.reducing(U identity, Function<? super T, ? extends U> mapper, BinaryOperator<U> op)

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        // reducing(BinaryOperator<T> op) :
        // No identity value, returns Optional.
        Optional<Integer> sum1 = numbers.stream()
                .collect(Collectors.reducing((a, b) -> a + b));

        // reducing(T identity, BinaryOperator<T> op) :
        // Provides an identity value, returns a result directly
        // identity : default value for empty streams
        Integer sum2 = numbers.stream()
                .collect(Collectors.reducing(0, (a, b) -> a + b));

        // reducing(U identity, Function<? super T, ? extends U> mapper, BinaryOperator<U> op):
        // mapper : Maps each element before performing the reduction.
        // Useful when reducing custom objects after transforming them into a simpler form.
        Integer idSum = studentList.stream()
                .collect(Collectors.reducing(0, Student::getId, (a, b)->(a+b)));
        // or
        Double salaryTotal =  users.stream()
                .collect(Collectors.reducing(0.0, User::salary, (a, b)->(a+b)));



    }
}
