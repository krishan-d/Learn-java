package com.learning.io_networking.serialization;

import java.io.*;

public class SerializationDemo {
    static final String FILE_NAME = "data_directory//serialization.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
         * Serialization
         * */
        Person p = new Person(1000, "Eve", 20);

        FileOutputStream stream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(stream);

        out.writeObject(p);
        out.flush();
        System.out.println("success!");

        /*
         * Deserialization
         * */
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
        Person person = (Person) in.readObject();
        System.out.println(person.id + " " + person.name + " " + person.age);

        in.close();
    }
}
