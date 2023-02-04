package com.learning.io_networking.io.core_io_0;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReading {

    private static final String FILE_NAME = "src/main/resources/FileText.txt";

    public static void main(String[] args) {

        //NOTE:
        //We can load a file from various locations like classpath, URL, or jar files.
        //
        //Then we can use
        //BufferedReader to read line by line,
        //Scanner to read using different delimiters,
        //StreamTokenizer to read a file into tokens,
        //DataInputStream to read binary data and primitive data types,
        //SequenceInput Stream to link multiple files into one stream,
        //FileChannel to read faster from large files, etc.

    }

    //Helper method
    public static String readFromInputStream(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void readFromClasspath() {
        Class<FileReading> cl = FileReading.class;
        InputStream inputStream = cl.getResourceAsStream(FILE_NAME);
        //or
        /*
        * ClassLoader cLoader = FileReading.class.getClassLoader();
        * InputStream inputStream = cLoader.getResourceAsStream(FILE_NAME);
        */
        String data = readFromInputStream(inputStream);
    }

    public static void readUsingCommonIoLibrary() throws IOException {
        ClassLoader classLoader = FileReading.class.getClassLoader();
        File f = new File(Objects.requireNonNull(classLoader.getResource("FileText.txt")).getFile());
        String data = FileUtils.readFileToString(f, "UTF-8");

        //or
        FileInputStream is = new FileInputStream(FILE_NAME);
        String data1 = IOUtils.toString(is, StandardCharsets.UTF_8);
    }

    public static void readWithBufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String currLine = br.readLine();
        br.close();
    }

    public static void readFileUsingNIO() throws IOException {
        //Reading small File
        Path path = Paths.get(FILE_NAME);
        String read = Files.readAllLines(path).get(0);

        //Reading large File
        //BufferedReader br = Files.newBufferedReader(path);
        //String line = br.readLine();
    }

    public static void readFileUsingFilesLines() throws URISyntaxException, IOException {
        Path path = Paths.get(FileReading.class.getClassLoader().getResource("FileText.txt").toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
    }

    public static void readFileWithScanner() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILE_NAME));
        sc.useDelimiter("\s");
        while (sc.hasNext()) {
            String line = sc.next();
        }
        sc.close();
    }

    public static void readFileWithStreamTokenizer() throws IOException {

        FileReader rd = new FileReader(FILE_NAME);
        StreamTokenizer st = new StreamTokenizer(rd);

        //Token 1
        st.nextToken();
        if (st.ttype == StreamTokenizer.TT_WORD) System.out.println("WORD");

    }

    public static void readFileWithDataInputStream() throws IOException {
        String res = null;
        DataInputStream in = new DataInputStream(new FileInputStream(FILE_NAME));
        int nBytesToRead = in.available();
        if (nBytesToRead > 0) {
            byte[] data = new byte[nBytesToRead];
            in.read(data);
            res = new String(data);
        }
    }

    public static void readFileWithFileChannel() throws IOException {

        RandomAccessFile file = new RandomAccessFile(FILE_NAME, "r");
        FileChannel fileChannel = file.getChannel();

        int bufferSize = 1024;
        if (bufferSize > fileChannel.size()) bufferSize = (int) fileChannel.size();

        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        fileChannel.read(buffer);
        buffer.flip();

        String data = new String(buffer.array());

        fileChannel.close();
        file.close();
    }

    public static void readEncodedFile() throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8));
        String currentLine = reader.readLine();
        reader.close();
    }

    public static void readFromURL() throws IOException {
        URL urlObject = new URL("/");
        URLConnection urlConnection = urlObject.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String data = readFromInputStream(inputStream);
    }

    public static void readFileFromJAR() {
        /*Class clazz = Matchers.class;
        InputStream inputStream = clazz.getResourceAsStream("/LICENSE.txt");
        String data = readFromInputStream(inputStream);*/
    }

}
