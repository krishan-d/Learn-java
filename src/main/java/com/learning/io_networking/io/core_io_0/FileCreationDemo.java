package com.learning.io_networking.io.core_io_0;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreationDemo {

    private static final String FILE_NAME = "src/main/resources/FileToCreate.txt";

    public static void main(String[] args) throws IOException {

        //

        //NIO Files.createFile()
        //For already existing File, FileAlreadyExistException is raised.
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createFile(newFilePath);

        //File.createNewFile()
        File f = new File(FILE_NAME);
        boolean isCreated = f.createNewFile();

        //FileOutputStream
        try (FileOutputStream out = new FileOutputStream(FILE_NAME)) {
            //...

        }

        //Using Guava:
        //com.google.common.io.Files.touch(new File(FILE_NAME));

        //Using Apache Common IO
        //FileUtils.

    }

    public static void cleanupFile() {
        File f = new File(FILE_NAME);
        f.delete();
    }
}
