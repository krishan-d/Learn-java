package com.learning._8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeRepository {
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

    public static List<Employee> getUnsortedEmployeeList() {
        return Stream.of(
                new Employee(200, "Eve", 100000.47, Arrays.asList("12345678", "123456745")),
                new Employee(204, "Chris", 210000.04, Arrays.asList("123400009", "123450887"))
                ).toList();
    }
}
