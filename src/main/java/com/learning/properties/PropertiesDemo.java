package com.learning.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        /*
        Properties p = new Properties();
        OutputStream os = new FileOutputStream("src/main/resources/config.properties");

        p.setProperty("url", "localhost:3306/myDb");
        p.setProperty("user", "eve");

        p.store(os, "");*/


        Properties p = new Properties();
        InputStream is = new FileInputStream("src/main/resources/config.properties");
        p.load(is);

        System.out.println(p.getProperty("url"));

    }
}
