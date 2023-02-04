package com.learning.io_networking.io.core_io_0;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingToFile {

    private static final String FILE_NAME = "src/main/resources/WriteToFile.txt";

    public static void main(String[] args) throws IOException {

        /*
        * NOTES:
        * 1. If we try to read from a file that doesn't exist, a FileNotFoundException will be thrown.
        * 2. If we try to write to a file that doesn't exist, the file will be created first and no exception will be thrown.
        * 3. It is very important to close the stream after using it, as it is not closed implicitly, to release any resources associated with it.
        * 4. In output stream, the close() method calls flush() before releasing the resources, which forces any buffered bytes to be written to the stream.
        *
        * Looking at the common usage practices, we can see, for example, that
        * PrintWriter is used to write formatted text,
        * FileOutputStream to write binary data,
        * DataOutputStream to write primitive data types,
        * RandomAccessFile to write to a specific position, and
        * FileChannel to write faster in larger files.
        * */

        //writeWithBufferedWriter();
        writeWithFileChannel(FILE_NAME);
    }

    public static void writeWithBufferedWriter() throws IOException {
        //To write a string to a file
        String str = "Hi Eve!";
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write(str);
        writer.close();
    }

    public static void appendWithBufferedWriter() throws IOException {

        String str = "Hi Eve!";
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.append(' ');
        writer.append("Morning");
        writer.close();
    }

    public static void writeWithPrintWriter() throws IOException {
        //To write formatted text to a file
        PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));
        writer.print("Some String!");
        writer.printf("Product is %s and price is %d", "iPhone", 1000);
        writer.close();
    }

    public static void writeWithFileOutputStream() throws IOException {
        //To write binary data to a file
        String str = "Hello!";
        FileOutputStream out = new FileOutputStream(FILE_NAME);
        byte[] strToBytes = str.getBytes();
        out.write(strToBytes);
        out.close();
    }

    public static void writeWithDataOutputStream() throws IOException {

        String str = "Hello!" ;
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));

        out.writeUTF(str);
        out.close();

    }

    public static void writeWithRandomAccessFile(String fileName, int data, long position) throws IOException {
        //Write to position
        RandomAccessFile writer = new RandomAccessFile(fileName, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }

    public static void readFromPosition(String fileName, long position) throws IOException {
        //Read the int stored at a specific location
        RandomAccessFile file = new RandomAccessFile(fileName, "r");
        file.seek(position);
        int result = file.readInt();
        System.out.println(result);
        file.close();
    }

    public static void writeToSpecificPositionInFile(String fileName) throws IOException {
        int data1 = 2014;
        int data2 = 1300;

        writeWithRandomAccessFile(fileName, data1, 4);
        readFromPosition(fileName, 4);
    }

    public static void writeWithFileChannel(String fileName) throws IOException {

        String str = "Hello!";
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = file.getChannel();
        byte[] strToBytes = str.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(strToBytes.length);
        buffer.put(strToBytes);
        buffer.flip();
        fileChannel.write(buffer);

        file.close();
        fileChannel.close();
    }

    public static void writeWithFilesClass(String fileName) throws IOException {
        String str = "hello!";
        Path path = Paths.get(fileName);
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);
        System.out.println(read);
    }

    public static void writeToATemporaryFile() throws IOException {

        String data = "Hello!";
        File tempFile = File.createTempFile("Test", ".tmp");
        FileWriter writer = new FileWriter(tempFile);
        writer.write(data);
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile));
        String res = bufferedReader.readLine();
        System.out.println(res);
        bufferedReader.close();

    }

    public static void lockFileBeforeWriting(String fileName) throws IOException {

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = file.getChannel();

        //FileLock lock = null;
        FileLock lock = fileChannel.tryLock();

        file.writeChars("Test Lock!");
        lock.release();

        file.close();
        fileChannel.close();
    }
}
