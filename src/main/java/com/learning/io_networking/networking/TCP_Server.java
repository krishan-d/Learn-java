package com.learning.io_networking.networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    TCP_Server(int port) {
        //
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started!" + "\nWaiting for a client ...");
            socket = server.accept();
            System.out.println("Client Accepted!");

            //Take input from client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("End")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Closing connection!");
            socket.close();
            in.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = 5000;
        TCP_Server server = new TCP_Server(port);
    }
}
