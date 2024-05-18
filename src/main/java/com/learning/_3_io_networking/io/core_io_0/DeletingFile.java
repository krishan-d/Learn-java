package com.learning._3_io_networking.io.core_io_0;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeletingFile {

    public static void main(String[] args) throws IOException, InterruptedException {

        //deleteFile();
        deleteFileUsingJDK7();
        //deleteFileUsingCommonsIo();
    }

    public static void deleteFile() throws IOException, InterruptedException {

        //The file must exist before the deletion operation, If it doesn't, API will not throw any exception but will return false.

        String source = "src/main/resources/FileToDelete.txt";
        new File(source).createNewFile();

        Thread.sleep(4000);
        File FileToDel = new File(source);
        boolean isDeleted = FileToDel.delete();
        System.out.println(isDeleted);
    }

    public static void deleteFileUsingJDK7() throws IOException, InterruptedException {

        //If file doesn't exist when delete operation is triggered,
        //an NoSuchFileException will be thrown by API.

        String source = "src/main/resources/FileToDelete.txt";
        Path of = Path.of(source);
        Files.createFile(of);

        Thread.sleep(4000);
        Files.delete(of);
    }

    public static void deleteFileUsingCommonsIo() throws IOException, InterruptedException {

        //Commons IO allows to control the exception behaviour when deleting a file.

        String source = "src/main/resources/FileToDelete_CommonsIo.txt";
        FileUtils.touch(new File(source));

        Thread.sleep(4000);
        //For a quiet delete that swallows any possible exceptions
        File fileToDel = FileUtils.getFile(source);
        boolean success = FileUtils.deleteQuietly(fileToDel);
        System.out.println(success);

        //or
        //For an exception to be thrown:
        FileUtils.touch(new File(source));
        Thread.sleep(4000);
        FileUtils.forceDelete(FileUtils.getFile(source));
    }
}
