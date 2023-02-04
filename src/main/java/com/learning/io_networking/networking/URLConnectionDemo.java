package com.learning.io_networking.networking;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String[] args) {
        String hostName = "https://www.coursera.org/";
        try {
            URL url = new URL(hostName);
            URLConnection urlCon = url.openConnection();

            InputStream stream = urlCon.getInputStream();
            int i;
            while ((i = stream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception ee) {
            System.out.println(ee);
            ee.getStackTrace();
        }
    }
}
