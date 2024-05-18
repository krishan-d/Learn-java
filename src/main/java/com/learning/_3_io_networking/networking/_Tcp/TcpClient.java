package com.learning._3_io_networking.networking._Tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TcpClient {
    Socket socket;
    DataOutputStream dos;
    BufferedReader br;

    TcpClient(String address, int port) {
        //Establish connection...
        try {
            socket = new Socket(address, port);
            System.out.println("Connected!");

            br = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        String message = "";
        while ( !message.equalsIgnoreCase("End") ) {
            try {
                message = br.readLine();
                dos.writeUTF(message);
                dos.flush();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //Close connection
        try {
            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TcpClient("127.0.0.1", 5000);
    }
}
