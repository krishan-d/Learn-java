package com.learning._3_io_networking.networking._Tcp._2w;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tw_Server {
    Tw_Server(int port) {
        DataInputStream din;
        DataOutputStream output;
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket socket = ss.accept();

            din = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2;
            while (!str.equals("End")) {
                str = din.readUTF();
                System.out.println("client says: " + str);

                str2 = br.readLine();
                output.writeUTF(str2);
                output.flush();
            }

            din.close();
            socket.close();
            ss.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 3333;
        //new Tw_Server(port);

        String FromClient, ToClient;
        ServerSocket server = new ServerSocket(port);
        /*Loop1:
        while (true) {
            Socket connected = server.accept();
            System.out.println("THE CLIENT " + connected.getInetAddress() + ":" + connected.getPort() + " IS CONNECTED!");

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connected.getInputStream()));

            PrintWriter outToClient = new PrintWriter(connected.getOutputStream(), true);

            while (true) {
                System.out.println("SEND[Type q or Q To Quit]:");
                ToClient = inFromUser.readLine();

                if (ToClient.equalsIgnoreCase("q")) {
                    outToClient.write(ToClient);
                    connected.close();
                    break Loop1;
                }
                outToClient.println(ToClient);

                fromClient = inFromClient.readLine();
                if (fromClient.equalsIgnoreCase("q")) {
                    connected.close();
                    break;
                }
                System.out.println("RECEIVED: " + fromClient);
            }
        }*/

        Socket connected = server.accept();
        System.out.println("THE CLIENT " + connected.getInetAddress() + ":" + connected.getPort() + " IS CONNECTED!");

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connected.getInputStream()));

        PrintWriter outToClient = new PrintWriter(connected.getOutputStream(), true);

        while (true) {
            FromClient = inFromClient.readLine();
            if (FromClient.equalsIgnoreCase("q")) {
                connected.close();
                break;
            }
            System.out.println("RECEIVED: " + FromClient);

            ToClient = inFromUser.readLine();
            if (ToClient == null || ToClient.isEmpty()) break;
            outToClient.println(ToClient);
            if (ToClient.equalsIgnoreCase("q")) {
                connected.close();
                break;
            }
        }
    }
}
