package com.learning._3_io_networking.networking;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class HttpURLConnectionDemo {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        String hostname = "https://www.coursera.org/";
        try {
            URL url = new URL(hostname);
            connection = (HttpURLConnection) url.openConnection();
            System.out.println("ResponseCode = " + connection.getResponseCode());

            for (int i = 1; i <= 8; i++) {
                System.out.println(connection.getHeaderFieldKey(i) + " = " + connection.getHeaderField(i));
            }
            connection.disconnect();
        } catch (UnknownHostException ee) {
            assert connection != null;
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
