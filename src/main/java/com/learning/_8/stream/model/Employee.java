package com.learning._8.stream.model;

import java.util.List;

public class Employee {
    int id;
    String name;
    double salary;
    private List<String> phoneNumbers;


    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Employee(int id, String name, double salary, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNumbers = phoneNumbers;
    }

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
