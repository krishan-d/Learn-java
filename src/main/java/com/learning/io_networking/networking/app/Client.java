package com.learning.io_networking.networking.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    /*private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9090;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server: " + socket);
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new ServerMessageReader(in).start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
//                out.println(message);
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + SERVER_ADDRESS);
            System.exit(1);
        }
    }

    private static class ServerMessageReader extends Thread {
        private BufferedReader in;

        public ServerMessageReader(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            try {
                while (true) {
                    String message = in.readLine();
                    if (message == null) {
                        System.out.println("Connection to server closed.");
                        out.close();
                        System.exit(0);
                    }
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }*/
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9090;
    private static String name;

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to the chat server");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String message = in.nextLine();
                if (message.startsWith("SUBMITNAME")) {
                    System.out.print("Enter a unique name: ");
                    name = new Scanner(System.in).nextLine();
                    out.println(name);
                } else if (message.startsWith("NAMEACCEPTED")) {
                    System.out.println("Name accepted, start chatting");
                    break;
                }
            }
            while (true) {
                String input = new Scanner(System.in).nextLine();
                out.println(input);
            }
        } catch (UnknownHostException e) {
            System.err.println("Error: Unknown host " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error: Could not connect to " + SERVER_ADDRESS);
            System.exit(1);
        }
    }
}
