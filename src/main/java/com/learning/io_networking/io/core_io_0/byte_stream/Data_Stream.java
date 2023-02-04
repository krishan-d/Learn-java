package com.learning.io_networking.io.core_io_0.byte_stream;

import java.io.*;

public class Data_Stream {
    static final String FILE_NAME = "data_directory//data_stream.txt";

    public static void main(String[] args) throws IOException {

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(FILE_NAME));
             DataInputStream dataIn = new DataInputStream(new FileInputStream(FILE_NAME))) {

            // writing string to a file encoded as modified UTF-8
            dataOut.writeUTF("hello, nice to meet you!");

            // Reading data from the same file
            while (dataIn.available() > 0) {
                String k = dataIn.readUTF();
                System.out.print(k + " ");
            }
        }
    }
}
