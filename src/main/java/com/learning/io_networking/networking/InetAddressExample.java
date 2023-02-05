package com.learning.io_networking.networking;

import java.net.InetAddress;
import java.util.Arrays;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // To get and print InetAddress of the Local Host
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Localhost: " + address);

            InetAddress ip = InetAddress.getByName("www.coursera.org");

            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
            System.out.println("ip.getAddress() = " + Arrays.toString(ip.getAddress()));
            System.out.println("ip.isAnyLocalAddress() = " + ip.isAnyLocalAddress());
            System.out.println("ip.isMCGlobal() = " + ip.isMCGlobal());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
