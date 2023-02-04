package com.learning.io_networking.networking;

import java.io.*;
import java.net.Socket;

public class Tw_Client {
    Tw_Client(String address, int port) {
        Socket socket;
        DataInputStream din;
        DataOutputStream output;
        BufferedReader br;

        try {
            socket = new Socket(address, port);

            din = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2;
            while (!str.equalsIgnoreCase("End")) {
                str = br.readLine();
                output.writeUTF(str);
                output.flush();

                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }

            output.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 3333;
        //new Tw_Client(ip, 3333);

        String FromServer, ToServer;
        Socket clientSocket = new Socket(ip, port);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true) {
            ToServer = inFromUser.readLine();
            if (ToServer == null || ToServer.isEmpty()) break;
            outToServer.println(ToServer);
            if (ToServer.equalsIgnoreCase("q")) {
                clientSocket.close();
                break;
            }

            FromServer = inFromServer.readLine();
            if (FromServer.equalsIgnoreCase("q")) {
                clientSocket.close();
                break;
            }
            System.out.println("RECEIVED: " + FromServer);
        }
    }
}
