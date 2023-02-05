package com.learning._8.stream;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void salaryIncrement(Double percentage) {
        double newSalary = salary + percentage * salary / 100;
        setSalary(newSalary);
    }

    public String toString() {
        return "Id: " + id + " Name:" + name + " Price:" + salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeRepository {
    private List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    }

    public Employee findId(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id)
                return emp;
        }
        return null;
    }
}

public class StreamExample2 {

    public static void main(String[] args) throws IOException {

        //Stream Creation
        Employee[] arrayEmployees = {
                new Employee(1, "Eve", 100000.0),
                new Employee(2, "Mark", 200000.0),
                new Employee(3, "Zane", 300000.0)
        };

        Stream<Employee> stream = Stream.empty(); //Empty stream

        stream = Stream.of(arrayEmployees);
        //OR
        List<Employee> empList = Arrays.asList(arrayEmployees);
        stream = empList.stream();
        //OR
        stream = Stream.of(arrayEmployees[0], arrayEmployees[1], arrayEmployees[2]);
        //OR
        Stream.Builder<Employee> streamBuilderEmp = Stream.builder();
        streamBuilderEmp.accept(arrayEmployees[0]);
        streamBuilderEmp.accept(arrayEmployees[1]);
        streamBuilderEmp.add(arrayEmployees[2]);
        stream = streamBuilderEmp.build();


        //Stream Operations:

        //forEach
        empList.stream().forEach(e -> e.salaryIncrement(10.0));
        //OR
        empList.forEach(e -> e.salaryIncrement(10.0));

        //map
        //stream of Integers into stream of Employee [whenMapIdToEmployee thenGetEmployeeStream]
        EmployeeRepository employeeRepository = new EmployeeRepository(empList);

        Integer[] empIds = {1, 3};
        List<Employee> employees = Stream.of(empIds).map(employeeRepository::findId).collect(Collectors.toList());
        System.out.println("" + employees);

        //collect
        List<Employee> employees1 = empList.stream().collect(Collectors.toList());
        System.out.println("collect: " + employees1);

        //filter
        Integer[] empIds1 = {1, 2, 3, 4};
        List<Employee> employees2 = Stream.of(empIds1).map(employeeRepository::findId)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 200000).toList();
        System.out.println("filter: " + employees2);

        //findFirst : Return an Optional for the 1st entry in the stream
        Employee employee = Stream.of(empIds1).map(employeeRepository::findId)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);
        System.out.println("findFirst: " + employee);

        //toArray
        Employee[] empArray = empList.stream().toArray(Employee[]::new);

        //flatMap
        //Stream can hold complex data structure like Stream<List<String>>.
        //In this case, flatMap() helps to flatten data structure to simplify further operations.
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Hi", "Eve"),
                Arrays.asList("Hey", "Lyn")
        );
        List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("flatMap: " + namesFlatStream);

        /*
        peek
        Intermediate operation
        To perform multiple operations on Each Element of the stream before any terminal operation applied.
        Similar to forEach
        */
        List<Employee> employees3 = empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("peek: " + employees3);

        /*
        Note:
        Stream pipeline consist of a stream source, followed by zero or more Intermediate operations,
        and a Terminal operation.
        */

        /*
        Lazy Evaluation:
        Computation on the source data is only performed when the terminal operation is initiated,
        and source elements are consumed only as needed.

        All intermediate operations are lazy, so they’re not executed until a result of a processing is actually needed.
        */

        //Comparison based Stream operations:
        //sorted

        //empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()));
        //OR
        List<Employee> employees4 = empList.stream().sorted(Comparator.comparing(Employee::getName)).toList();
        System.out.println("sorted (by name): " + employees4);

        //min and max
        Employee firstEmployee = empList.stream()
                .min(Comparator.comparing(Employee::getId))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("min: " + firstEmployee);

        Employee maxSalEmp = empList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max: " + maxSalEmp);

        /*
        distinct:
        distinct() doesn't take any argument and return the distinct element in the stream, eliminating duplicates.
        It uses equals() to decide whether two elements are equal or not.
        */
        List<Integer> integerList = Arrays.asList(2, 4, 3, 2, 7, 3);
        List<Integer> distinctIntList = integerList.stream()
                .distinct()
                .toList();
        System.out.println("distinct: " + distinctIntList);

        /*
        allMatch, anyMatch and noneMatch
        Terminal operations
        These operations all take a Predicate and return boolean.
        */
        List<Integer> integerList1 = Arrays.asList(2, 4, 6, 7, 8);
        boolean allEven = integerList1.stream().allMatch(i -> i % 2 == 0);
        boolean anyEven = integerList1.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = integerList1.stream().noneMatch(i -> i % 3 == 0);

        System.out.println("allEven = " + allEven + " anyEven = " + anyEven + " noneMultipleOfThree = " + noneMultipleOfThree);

        /*
        Stream Specialization:
        IntStream, LongStream and DoubleStream - are primitive specialization for int, long and double.
        Do not extend Stream but extend BaseStream.
        Not all operations supported by Stream are present in these stream implementations. Such as min(), max().
        */
        //IntStream creation
        int latestEmpId = empList.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("IntStream: " + latestEmpId);

        //OR using
        IntStream.of(1, 2, 3);
        IntStream.range(1, 10);

        double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("DoubleStream: " + avgSal);

        /*
        Reducing operations
        reduce()
        findFirst(), min() and max()*/

        Double sumSal = empList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        /*
        Advance collect:
        */
        //Collectors.joining()
        String empNames = empList.stream().map(Employee::getName)
                .collect(Collectors.joining(", ", "", "")).toString();
        System.out.println("collect (joining): " + empNames);

        //Collectors.toSet()
        Set<String> empNamesSet = empList.stream().map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println("collect (toSet): " + empNamesSet);

        //Collectors.toCollection
        Stack<String> empNamesStack = empList.stream().map(Employee::getName)
                .collect(Collectors.toCollection(Stack::new));
        System.out.println("collect (toCollection): " + empNamesStack);

        //Collectors.averagingInt | averagingDouble | summingInt | summingDouble
        double averageSalary = empList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("averagingDouble: " + averageSalary);

        //Collectors.summarizingDouble
        //Collecting statistical information about stream's elements
        DoubleSummaryStatistics statistics = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("collect (summarizingDouble): " + statistics);
        //System.out.println("count: " + statistics.getCount() + " average: " + statistics.getAverage());
        //OR
        //Generates similar result
        DoubleSummaryStatistics stats = empList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();


        //Collectors.partitioningBy
        //Stream Partition -> Map
        //Partition a stream into two, based on certain Predicate
        List<Integer> integerList2 = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = integerList2.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("collect (partitioningBy): " + isEven);

        /*
        Collectors.groupingBy
        StreamGroupingBy -> Map
        groupingBy() offers advanced partitioning, where stream can be partitioned into more than two groups
        Takes classification function (applied to each element) as its parameter.
        Value returned by function is used as key to the map.
        */
        Map<Character, List<Employee>> groupByAlphabet = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0))); //Grouped employees based on initial char of their name
        System.out.println("collect (groupingBy): " + groupByAlphabet);
        System.out.println(groupByAlphabet.get('Z').get(0).getName());

        //Collectors.mapping
        //Stream Mapping -> Map
        //To group data into a type other than the element type
        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getId, Collectors.toList())));
        System.out.println("collect (mapping): " + idGroupedByAlphabet);
        System.out.println(idGroupedByAlphabet.get('E').get(0));

        /*
        Collectors.Reducing
        Stream Reducing -> Value
        Similar to reduce().
        Returns a collector which performs a reduction of its input elements.
        Most useful when used in a multi-level reduction, downstream of groupingBy() or partitioningBy().
        To perform simple reduction on a stream, use reduce() instead.
        */
        double percentage = 10.0;
        Double salIncreaseOverhead = empList.stream()
                .collect(Collectors.reducing(0.0, e -> e.getSalary() * percentage, Double::sum));
        //OR similarly using map and reduce separately
        //salIncreaseOverhead = empList.stream().map(e -> e.getSalary() * percentage).reduce(0.0, Double::sum);

        System.out.println("collect (reducing): " + salIncreaseOverhead);

        //reducing with groupingBy
        //Grouping And Reducing -> Map
        Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

        Map<Object, Optional<Employee>> longestNameByAlphabet = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
        System.out.println("collect (reducing with groupingBy): " + longestNameByAlphabet);
        System.out.println(longestNameByAlphabet.get('Z').get().getName());


        //Collectors.collectingAndThen
        //Pushing collector to perform additional transformation
        Set<Employee> unmodifiableSet = empList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        System.out.println("collectingAndThen: " + unmodifiableSet);

        //Will raise UnsupportedOperationException
        //unmodifiableSet.add(new Employee(4, "Noor", 100000.0));
        //unmodifiableSet.remove(arrayEmployees[1]);

        /*
        Parallel Streams:
        To perform operations in parallel
        */
        empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));

        /*
        Infinite Stream
        */
        //generate
        Stream.generate(Math::random)
                .limit(4)
                .forEach(System.out::println);

        //iterate
        List<Integer> evenNumberStream = Stream.iterate(2, i -> i * 2)
                .limit(4).toList();

        /*
        File Operations*/
        //Write operation
        String[] words = {"Hi", "Eve", "Hope", "you are well!"};
        String fileName = "data_directory//stream_operation.txt";
        Path of = Path.of(fileName);
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(of))) {
            Stream.of(words).forEach(pw::println);
        }

        //Read operation
        int length = 4;
        List<String> str;
        try (Stream<String> fileStream = Files.lines(of)) { //File To Stream
            str = fileStream
                    .filter(s -> s.length() == length)
                    .filter(s -> s.compareToIgnoreCase(
                            new StringBuilder(s).reverse().toString()) == 0).toList();
        }
        System.out.println(str.contains("Eve") + " " + str.contains("Hope"));

    }
}
