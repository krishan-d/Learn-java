package com.learning._3_io_networking.io;

import java.io.*;

public class IoStream {

    /*
     * Stream:
     * streams are the sequence of data that are read from the source and written to the destination.
     * input stream : read data from the source.
     * output stream : write data to the destination.
     *
     * Types:
     * 1.Byte Stream : read and write 1 byte(8 bit) of data.
     * byte stream classes are derived from base abstract classes InputStream and OutputStream.
     *
     *       InputStream
     *           BufferedInputStream
     *           DataInputStream
     *           FileInputStream
     *           ByteArrayInputStream
     *           ObjectInputStream
     *       OutputStream
     *           BufferedOutputStream
     *           DataOutputStream
     *           FileOutputStream
     *           ByteArrayOutputStream
     *           ObjectOutputStream
     *           PrintStream
     *
     * 2.Character Stream : read and write one character of data.
     * character stream classes are derived from base abstract classes Reader and Writer.
     *
     *       Reader
     *           |BufferedReader
     *   extends>|InputStreamReader
     *               |FileReader
     *           |StringReader
     *       Writer
     *           |BufferedWriter
     *           |OutputStreamWriter
     *               |FileWriter
     *           |StringWriter
     *
     * */

    static final String FILE_NAME = "data_directory//io_stream.txt";
    static final String INPUT_FILE_NAME = "data_directory//input.txt";
    static final String OUTPUT_FILE_NAME = "data_directory//output.txt";

    public static void main(String[] args) {

        /*
         * InputStream: [abstract superclass]
         *
         * Methods:
         * read() : reads one byte of data from the input stream
         * read(byte[] array) : reads bytes from the stream and stores in the specified array
         * available() -> return number of bytes available in input stream
         * mark() : marks the position in the input stream up to which data has been read
         * reset() -> return control to the point in stream where mark was set
         * markSupported() : checks if the mark() and reset() method is supported in the stream
         * skips() : skips and discards the specified number of bytes from the input stream
         * close() : closes the input stream
         *
         * OutputStream: [abstract superclass]
         *
         * Methods:
         * write() - writes the specified byte to the output stream
         * write(byte[] array) - writes the bytes from the specified array to the output stream
         * flush() - forces to write all data present in output stream to the destination
         * close() - closes the output stream
         * */

        String data = "This is a line of text inside the file.";
        byte[] array = new byte[100];

        try {
            OutputStream out = new FileOutputStream(OUTPUT_FILE_NAME);

            // Converts the string into bytes
            byte[] dataBytes = data.getBytes();

            // Writes data to the output stream
            out.write(dataBytes);
            System.out.println("Data is written to the file.");

            out.close();

            InputStream input = new FileInputStream(INPUT_FILE_NAME);
            System.out.println("Available bytes: " + input.available());

            // Read byte from the input stream
            long l = input.read(array);
            System.out.println("Read bytes: " + l);
            System.out.println("Reading data from file...");

            // Convert byte array into string
            String string = new String(array);
            System.out.println("Data: " + string);
            //System.out.println("Byte Array: " + Arrays.toString(array));

            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            byte[] bWrite = "Hi Krishna!\nHope you are well.\nThanks".getBytes();
            OutputStream os = new FileOutputStream(FILE_NAME);
            //for (byte b : bWrite) os.write(b);   // writes the bytes
            //or
            os.write(bWrite);
            os.close();

            InputStream is = new FileInputStream(FILE_NAME);
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "");
            }
            //or
            //byte[] array1 = new byte[size];
            //is.read(array1);

            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }

    }
}
