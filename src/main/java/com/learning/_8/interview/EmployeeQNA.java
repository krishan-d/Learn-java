package com.learning._8.interview;


import java.util.*;
import java.util.stream.Collectors;

public class EmployeeQNA {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        // 1. How many male and female employees are there in the organization?

        Map<String, Long> map1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(map1);


        // 2. Print the name of all departments in the organization?
        List<String> l1 = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(l1);


        // Query 3.3 : What is the average age of male and female employees?
        Map<String, Double> map2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(map2);


        // Query 3.4 : Get the details of highest paid employee in the organization?
        Optional<Employee> employee = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        System.out.println(employee);

        // Query 3.5 : Get the names of all employees who have joined after 2015?
        List<String> l2 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(l2);


        // Query 3.6 : Count the number of employees in each department?
        Map<String, Long> map3 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map3);


        // Query 3.7 : What is the average salary of each department?
        Map<String, Double> map4 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map4);

        // Query 3.8 : Get the details of youngest male employee in the product development department?
        Optional<Employee> emp2 = employeeList.stream()
                .filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development")).sorted(Comparator.comparing(Employee::getAge))
                .findFirst();
        System.out.println(emp2.get());


        // Query 3.9 : Who has the most working experience in the organization?
        Optional<Employee> emp4 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.println(emp4);


        // Query 3.10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Long> map5 = employeeList.stream()
                .filter(e-> e.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(map5);


        // Query 3.11 : What is the average salary of male and female employees?
        Map<String, Double> map6 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map6);


        // Query 3.12 : List down the names of all employees in each department?
        Map<String, List<Employee>> map7 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(map7);


        // Query 3.13 : What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics statistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());


        // Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> map8 = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        System.out.println(map8);


        // Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .limit(1)
                .forEach(e -> System.out.println("name: " + e.getName() + " age: " + e.getAge() + " department: " + e.getDepartment()));


    }
}
