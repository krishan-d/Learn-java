package com.learning.io_networking.io.core_io_0.byte_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Byte_Stream {
    public static void main(String[] args) throws IOException {

        /*
         * ByteArrayInputStream:
         * reads an array of input data(in bytes)
         *
         * Method:
         * finalize()
         * mark()
         * reset()
         * markSupported()
         * */
        byte[] array = {1, 2, 3, 4};

        try {
            /*
             * ByteArrayInputStream input = new ByteArrayInputStream(byte[] arr);
             *
             * ByteArrayInputStream input = new ByteArrayInputStream(byte[] arr, int start, int length);
             * */
            ByteArrayInputStream input = new ByteArrayInputStream(array);

            long skipped = input.skip(2);
            System.out.print("Skipped bytes: " + skipped + " Now, The bytes read from the input stream: ");

            /*
             * read()
             * read(byte[] array)
             * read(byte[] array, int start, int length)
             * */

            for (int i = 0; i < array.length; i++) {
                int data = input.read();
                System.out.print(data + ", ");
            }
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        /*
         * ByteArrayOutputStream:
         * write an array of output data (in bytes).
         * */

        String data = "This is a line of text inside the string.";

        try {
            // Creates an output stream
            /*
             * ByteArrayOutputStream out = new ByteArrayOutputStream();
             *
             * ByteArrayOutputStream out = new ByteArrayOutputStream(int size);
             * */
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] byteArray = data.getBytes();

            // Writes data to the output stream
            /*
             * write(int byte)
             * write(byte[] array)
             * write(byte[] array, int start, int length)
             * writeTo(ByteArrayOutputStream output):
             * writes the entire data of the current output stream to the specified output stream
             * */
            out.write(byteArray);

            byte[] byteData = out.toByteArray();  // return an array of bytes
            System.out.println("Data using toByteArray: " + Arrays.toString(byteData));
            for (byte byteDatum : byteData) {
                System.out.print((char) byteDatum);
            }

            // Retrieves data from the output stream in string format
            String streamData = out.toString();
            System.out.println("Output stream: " + streamData);

            /*
             * Methods:
             * size()
             * flush()
             * */

            out.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

        while (bOutput.size() != 10) {
            // Gets the inputs from the user
            bOutput.write("hello".getBytes());
        }
        byte[] b = bOutput.toByteArray();
        System.out.println("Print the content");

        for (byte value : b) {
            // printing the characters
            System.out.print((char) value + "   ");
        }
        System.out.println();

        int c;
        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        System.out.println("Converting characters to Upper case ");

        for (int i = 0; i < 1; i++) {
            while ((c = bInput.read()) != -1) {
                System.out.println(Character.toUpperCase((char) c));
            }
            bInput.reset();
        }
    }
}
