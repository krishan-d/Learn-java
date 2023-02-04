package com.learning.io_networking.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileDemo {
    public static void main(String[] args) {
        String[] paths;
        File file;

        try {
            file = new File("C:\\Users\\krish\\Documents");

            paths = file.list();

            assert paths != null;
            for (String path : paths) System.out.println(path);
            boolean bool = file.canExecute();
            String abs = file.getAbsolutePath();
            System.out.println("Absolute path = " + abs);
            System.out.println("Is Executable = " + bool);


            file = new File("data_directory//new_file.txt");

            // creates the file
            file.createNewFile();

            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);

            // Writes the content to the file
            writer.write("This\n is\n an\n example\n");
            writer.flush();
            writer.close();

            // Creates a FileReader Object
            FileReader fr = new FileReader(file);
            char[] a = new char[50];
            fr.read(a);   // reads the content to the array

            for (char c : a)
                System.out.print(c);   // prints the characters one by one
            fr.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
