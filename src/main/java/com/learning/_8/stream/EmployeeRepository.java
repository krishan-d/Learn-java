package com.learning._8.stream;

import java.util.List;

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
