package com.learning.io_networking.networking;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class HttpURLConnectionDemo {
    public static void main(String[] args) {
        HttpURLConnection huc = null;
        String hostname = "https://www.coursera.org/";
        try {
            URL url = new URL(hostname);
            huc = (HttpURLConnection) url.openConnection();
            System.out.println("ResponseCode = " + huc.getResponseCode());

            for (int i = 1; i <= 8; i++) {
                System.out.println(huc.getHeaderFieldKey(i) + " = " + huc.getHeaderField(i));
            }
            huc.disconnect();
        } catch (UnknownHostException ee) {
            assert huc != null;
            huc.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
