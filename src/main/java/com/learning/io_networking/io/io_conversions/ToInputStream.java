package com.learning.io_networking.io.io_conversions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ToInputStream {

    public static void main(String[] args) throws IOException {

        String str = "Hi Team, Hope you are well!";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());

        String string = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining(","));

        System.out.println("string = " + string);

        //or
        string = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        //or
        string = null;
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)){
            string = scanner.useDelimiter("\\A").next();
            //"\\A" is a boundary marker regex that denotes the beginning of the input. Essentially, this means
            //next() call reads the entire input stream.
        }

        //or
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            outputStream.write(data, 0, nRead);
        }
        outputStream.flush();

        string = outputStream.toString(StandardCharsets.UTF_8);

    }
}
