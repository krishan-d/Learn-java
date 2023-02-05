package com.learning.io_networking.networking;

import java.net.URL;

public class URLExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/search?q=node&oq=node&sourceid=chrome&ie=UTF-8");

            System.out.println("Protocol: " + url.getProtocol()); //https
            System.out.println("Host Name: " + url.getHost()); //www.google.com
            System.out.println("Port Number: " + url.getPort()); //-1
            System.out.println("Default Port Number: " + url.getDefaultPort()); //443
            System.out.println("Query String: " + url.getQuery()); //q=node&oq=node&sourceid=chrome&ie=UTF-8
            System.out.println("Path: " + url.getPath()); // /search
            System.out.println("File: " + url.getFile()); // /search?q=node&oq=node&sourceid=chrome&ie=UTF-8
            System.out.println("Authority: " + url.getAuthority()); //www.google.com

            System.out.println(url.getContent().toString());

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
