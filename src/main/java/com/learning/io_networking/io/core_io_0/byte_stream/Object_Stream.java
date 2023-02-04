package com.learning.io_networking.io.core_io_0.byte_stream;

import java.io.*;

public class Object_Stream {
    static final String FILE_NAME = "data_directory/stream.txt";

    static class Person implements Serializable {
        String name, work;

        Person(String name, String work) {
            this.name = name;
            this.work = work;
        }
    }

    public static void main(String[] args) {
        /*
         * ObjectInputStream:
         * used to read objects that were previously written by ObjectOutputStream
         * Extends InputStream abstract class
         *
         * Working:
         * [ObjectInputStream] converts java objects into corresponding streams.This is known as [serialization].
         * Those converted streams can be stored in files or transferred through networks.
         *
         * To read these objects use [ObjectInputStream].
         * convert stream back to corresponding objects. This is known as [deserialization].
         *
         * ObjectOutputStream:
         * used to write objects that can be read by ObjectInputStream
         * Extends OutputStream abstract class
         *
         * methods:
         * write(): writes a byte of data to output stream
         * writeBoolean(): writes data in boolean form
         * writeChar()
         * writeInt()
         * writeObject(): writes object to output stream
         *
         * */

        int number = 5;
        String string = "This is Me!";

        Person p = new Person("Eve", "SE");

        try {
            FileOutputStream file = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            // Writing to file
            objectOutputStream.writeInt(number);
            objectOutputStream.writeObject(string);
            objectOutputStream.writeObject(p);

            objectOutputStream.close();

            FileInputStream stream = new FileInputStream(FILE_NAME);
            // Creating an object input stream
            ObjectInputStream objectInputStream = new ObjectInputStream(stream);

            System.out.println("Integer data: " + objectInputStream.readInt());
            System.out.println("String data: " + objectInputStream.readObject());
            Person person = (Person) objectInputStream.readObject();
            System.out.println("Person name: " + person.name + " and work: " + person.work);

            objectInputStream.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
