package com.learning.functionalprogramming.functionalinterface;

@java.lang.FunctionalInterface
interface PersonFunctionalInterface {
    Person createPerson(String name);
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static Person createClass_FromMethodReference(String name) {
        return new Person(name);
    }
}

public class FIExample {
    public static void main(String[] args) {
        //create normal anonymous class
        PersonFunctionalInterface anonymousClassExample = new PersonFunctionalInterface() {
            @Override
            public Person createPerson(String name) {
                return new Person(name);
            }
        };

        //OR
        //create anonymous class by lambda
        PersonFunctionalInterface interfaceExLambda = name -> new Person(name);

        //OR
        //create anonymous class by constructor reference
        PersonFunctionalInterface interfaceExConstructorReference = Person::new;

        //OR
        //create anonymous class by method reference
        PersonFunctionalInterface interfaceExMethodReference = Person::createClass_FromMethodReference;


        boolean isEqual = anonymousClassExample.createPerson("Eve").getName().equals("Eve");
        System.out.println(isEqual);

    }
}
