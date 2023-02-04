package com.learning.io_networking.io.core_io_0.byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Buffered_Stream {

    public static void main(String[] args) {
        /*
         * BufferedInputStream:
         * used with other input streams to read the data (in bytes) more efficiently.
         * extends InputStream
         *
         * Working:
         * BufferedInputStream maintains an internal buffer of 8192 bytes.
         * During read operation in BufferedInputStream, a chunk of bytes is read from disk and stored in internal buffer.
         * And from internal buffer bytes are read individually.
         * Hence, number of communication to disk is reduced. And reading bytes is faster.
         *
         * */

        try {
            FileInputStream file = new FileInputStream("input");
            // Creates BufferedInputStream
            BufferedInputStream buffer = new BufferedInputStream(file);

            // Creates a BufferedInputStream with specified size internal buffer
            // BufferedInputStream buffer = new BufferInputStream(file, int size);

            // buffer.skip(5); // skips 5 bytes

            int i = buffer.read();
            while (i != -1) {
                System.out.print((char) i);
                i = buffer.read();
            }

            buffer.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        /*
         * BufferedOutputStream:
         * used with other output streams to write the data.
         *
         * Working:
         * During the write operation, the bytes are written to the internal buffer instead of the disk.
         * Once the buffer is filled or the stream is closed, the whole buffer is written to the disk.
         *
         * */

        String data = "This is a line of text inside the file";

        try {
            // Creates a FileOutputStream
            FileOutputStream file = new FileOutputStream("output");

            // Creates a BufferedOutputStream
            BufferedOutputStream output = new BufferedOutputStream(file);

            byte[] array = data.getBytes();

            // Writes data to the output stream
            output.write(array);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
