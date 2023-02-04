package com.learning.io_networking.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TCP_Client {
    TCP_Client(String address, int port) {
        //Establish connection
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream out = null;
        try {
            //Initialize socket
            socket = new Socket(address, port);
            System.out.println("Connected!");
            //Takes input from Terminal
            input = new DataInputStream(System.in);
            //Sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }

        //String to read message from input
        String line = " ";

        //Keep reading until "End" is input
        while (!line.equals("End")) {
            try {
                assert input != null;
                line = input.readLine();
                assert out != null;
                out.writeUTF(line);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //Close connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new TCP_Client("127.0.0.1", 5000);
    }
}
