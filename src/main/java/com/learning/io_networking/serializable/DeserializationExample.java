package com.learning.io_networking.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    static final String FILE_NAME = "data_directory//serialization.ser";
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(FILE_NAME); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person p = (Person) ois.readObject();
            System.out.println(p.id + " " + p.name + " " + p.income);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
