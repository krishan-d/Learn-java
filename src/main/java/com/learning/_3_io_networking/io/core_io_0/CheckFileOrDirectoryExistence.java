package com.learning._3_io_networking.io.core_io_0;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckFileOrDirectoryExistence {

    private static final File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"));

    public static void main(String[] args) {

        //checkUsingNioFiles("FileNotExisting.txt");
        //checkUsingNioFiles("src/main/resources/FileText.txt");
        //checkUsingNioFiles("src/main/resources");

        //checkUsingIoFiles();
    }

    public static void checkUsingNioFiles(String filePath) {
        Path path = Paths.get(filePath);
        boolean isExist = Files.exists(path); //False
        System.out.println(isExist);

        //To check if a file or directory exists:
        boolean isDirectory = Files.isDirectory(path);
        boolean isRegularFile = Files.isRegularFile(path);

        boolean notExist = Files.notExists(path);

        //Note:
        //Sometimes the Files.exists(Path) returns false because we don't possess the required file permissions.
        //In such scenarios, we can use the Files.isReadable(Path) method to make sure the file is actually readable by the current user:
        boolean isReadable = Files.isReadable(path);
        boolean isReadable1 = Files.isReadable(Paths.get("/root/.bashrc"));
        System.out.println("isReadable: " + isReadable1);
    }

    public static void checkUsingIoFiles() {

        //NOTE:
        //For Java 7 or a newer version of Java, it's highly recommended to use the modern Java NIO APIs for these sorts of requirements.

        boolean isExist = new File("Invalid.txt").exists();
        System.out.println(isExist);

        //The exists() method doesn't care if it's a file or directory. Therefore, as long as it does exist, it'll return true.

        boolean isReadable = new File("/root/.bashrc").canRead();
        System.out.println(isReadable);

        File newDirectory = new File(TEMP_DIRECTORY, "new_directory");
        newDirectory.mkdir();

        if (!newDirectory.exists()) newDirectory.mkdir();
    }


}
