package com.learning._3_io_networking.io.core_io_0;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadingLargeFiles {

    public static void main(String[] args) {

        //...
    }

    public static void streamingThroughFile(String path) throws IOException {

        try (FileInputStream InputStream = new FileInputStream(path);
             Scanner sc = new Scanner(InputStream, StandardCharsets.UTF_8)) {

            while (sc.hasNext()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            if (sc.ioException() != null) throw sc.ioException();
        }
    }

    public static void streamingWithApacheCommonsIo(String file) throws IOException {

        try (LineIterator iterator = FileUtils.lineIterator(FileUtils.getFile(file), "UTF-8")) {
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                //do something here...
            }
        }
    }
}
