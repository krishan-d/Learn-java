package com.learning.io_networking.serializable;

import java.io.*;

public class SerializationExample {
    static final String FILE_NAME = "data_directory//serialization.ser";
    public static void main(String[] args) {

        Person person = new Person(1000, "Eve", 20);
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
