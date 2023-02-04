package com.learning.Interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Patient {
    private String name;
    private int age;
    private String disease;
    private double amount;

    public Patient() {
    }

    public Patient(String name, int age, String disease, double amount) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", disease='" + disease + '\'' +
                ", amount=" + amount +
                '}';
    }
}

public class HospitalPatients {

    public static void main(String[] args) {
        Patient p1 = new Patient("A", 18, "COVID", 10000);
        Patient p2 = new Patient("B", 20, "FEVER", 12000);
        Patient p3 = new Patient("C", 30, "COVID", 20000);
        Patient p4 = new Patient("D", 24, "COVID", 17000);

        List<Patient> patients = Arrays.asList(p1, p2, p3, p4);

        Predicate<Integer> age_predicate = x -> (x < 25);
        //Predicate<String> disease_predicate = x -> x.equals("COVID");
        //OR
        Predicate<String> disease_predicate = Predicate.isEqual("COVID");

        //covid patients whose age is not over 25
        patients.stream().filter(p -> p.getDisease().equals("COVID") && p.getAge() < 25).forEach(System.out::println);

        //Average amount to be paid by covid patients only
        double avgAmountToBePaid = patients.stream().filter(p -> p.getDisease().equals("COVID")).
                collect(Collectors.averagingDouble(Patient::getAmount));

        System.out.println(avgAmountToBePaid);

    }
}
