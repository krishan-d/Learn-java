package com.learning.io_networking.networking;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) {
        String hostName = "https://www.coursera.org/";
        try {
            URL url = new URL(hostName);
            URLConnection connection = url.openConnection();

            InputStream stream = connection.getInputStream();
            int i;
            while ((i = stream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.getStackTrace();
        }
    }
}
