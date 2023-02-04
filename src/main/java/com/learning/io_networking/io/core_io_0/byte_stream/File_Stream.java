package com.learning.io_networking.io.core_io_0.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class File_Stream {

    /*
     * FileInputStream:
     * Input stream that reads from a file
     *
     * Methods:
     *
     * finalize():	ensures that the close() method is called
     * getChannel():	returns the object of FileChannel associated with the input stream
     * getFD():	returns the file descriptor associated with the input stream
     * mark(): 	mark the position in input stream up to which data has been read
     * reset(): 	returns the control to the point in the input stream where the mark was set
     * */

    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("input");

            // Returns the number of available bytes
            System.out.println("Available bytes at the beginning: " + input.available());

            // Skips the 5 bytes
            long skip = input.skip(5);
            System.out.println("Input stream after skipping 5 bytes: " + skip);

            System.out.println("Data in the file: ");

            /*
             * read(): reads 1 byte
             * read(byte[] array): reads bytes from file and stores in specified array
             * read(byte[] array, int start, int length): reads number of bytes equal to [length] from file. And,
             * stores in specified array starting from position [start]
             * */
            int i = input.read(); // Reads the first byte
            while (i != -1) {
                System.out.print((char) i);
                // Reads next byte from the file
                i = input.read();
            }
            System.out.println("\nAvailable bytes at the end: " + input.available());
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        /*
         * FileOutputStream:
         * Output stream that write to a file.
         *
         * Methods:
         *
         * finalize():	ensures that the close() method is called
         * getChannel():	returns the object of FileChannel associated with the output stream
         * getFD():	returns the file descriptor associated with the output stream
         * */

        String data = "This is a line of text inside the file.";

        try {
            /*
             * Including the boolean parameter:
             * FileOutputStream output = new FileOutputStream(String path, boolean value);
             * True: new data appends, otherwise overwrites existing data
             *
             * Not including the boolean parameter:
             * FileOutputStream output = new FileOutputStream(String path);
             *
             * FileOutputStream output = new FileOutputStream(File fileObject);
             * */
            FileOutputStream output = new FileOutputStream("output");

            byte[] array = data.getBytes();

            /*
             * write(): writes 1 byte to file output stream
             * write(byte[] array): write bytes from specified array to output stream
             * write(byte[] array, int start, int length): write number of bytes equal to [length] to the output stream
             * from an array starting from position [start].
             * */
            output.write(array);

            /*
             * flush():
             * To clear the output stream. This method forces the output stream to write all data to the destination.
             * */
            output.flush();
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}