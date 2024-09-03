package com.learning._8.stream.model;

public record Person(long id, String firstName, String lastName, int age) {
}

/*public final class Person extends java.lang.Record {

public Person(long, java.lang.String);
public final java.lang.String toString();
public final int hashCode();
public final boolean equals(java.lang.Object);

public long id();
public java.lang.String name();
}*/
