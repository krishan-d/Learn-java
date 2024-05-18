package com.learning._3_io_networking.io.noi_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class NioAPIsDemo {

    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) {

        System.out.println("HOME = " + HOME); //C:\Users\krish

        //checkExistence();
        //System.out.println("isFileReadable() = " + isFileReadable());
        System.gc();
    }

    public static void checkExistence() {
        //To check if a file exists, use exists API.
        Path path = Paths.get(HOME);
        boolean isExist = Files.exists(path);
        System.out.println(isExist);

        //To check if a file does not exist, use notExists API.
        Path p = Paths.get(HOME + "/Nonexistent.txt");
        Boolean isNotExist = Files.notExists(p);
        System.out.println(isNotExist);
    }

    public static boolean isFileReadable() {
        Path p = Paths.get(HOME);
        return Files.isReadable(p);
    }

    public static boolean isFileRegularFile() {
        Path p = Paths.get(HOME);
        return Files.isRegularFile(p);
    }

    public static boolean isFileWritable() {
        Path p = Paths.get(HOME);
        return Files.isWritable(p);
    }

    public static boolean isFileExecutable() {
        Path p = Paths.get(HOME);
        return Files.isExecutable(p);
    }

    public static boolean isSameFilePaths() throws IOException {
        Path p = Paths.get(HOME);
        Path p1 = Paths.get(HOME);
        return Files.isSameFile(p, p1);
    }

    //Creating File

    public static void createNewFile() throws IOException {
        //To create a regular file, use createFile API

        String fileName = "myFile_" + UUID.randomUUID().toString() + ".txt";
        Path p = Paths.get(HOME + "/" + fileName);
        if (!Files.exists(p)) Files.createFile(p);
    }

    public void createNewDirectory() throws IOException {
        //createDirectory API
        //This operation requires that all name elements in the path exist, if not, we get IOException.

        String dirName = "myDir_" + UUID.randomUUID();
        Path p = Paths.get(HOME + "/" + dirName);

        if (!Files.exists(p)) Files.createDirectory(p);

        System.out.println("Files.exists(p) = " + Files.exists(p));
        System.out.println("Files.isRegularFile(p) = " + Files.isRegularFile(p));
        System.out.println("Files.isDirectory(p) = " + Files.isDirectory(p));
    }

    public static void createHierarchy() throws IOException {
        //To create a hierarchy of directories with a single call, we use the createDirectories method.

        String dirName = "myDir_" + UUID.randomUUID();
        Path dir = Paths.get(HOME + "/" + dirName);
        Path subDir = dir.resolve("subDir");

        if (!Files.exists(dir) && !Files.exists(subDir)) Files.createDirectories(subDir);

        System.out.println("Files.exists(dir) = " + Files.exists(dir));
        System.out.println("Files.exists(subDir) = " + Files.exists(subDir));
    }

    //Create Temporary Files
    public static void createTemporaryFilesFromPath() throws IOException {
        //createTempFile API

        String prefix = "Log_";
        String suffix = ".txt";
        Path p = Paths.get(HOME + "/");

        Files.createTempFile(p, prefix, suffix);

        System.out.println("Files.exists(p) = " + Files.exists(p));
        //Generated File name will be like Log_8821081429012075286.txt.
        //Long numeric string is system generated.
    }

    public static void createTemporaryFileWithDefaults() throws IOException {
        Path p = Paths.get(HOME + "/");
        Files.createTempFile(p, null, null);
        //This operation creates a file with a name like 8600179353689423985.tmp.
    }

    public static void createTempFileInTempDir() throws IOException {

        Path p = Files.createTempFile(null, null);
        System.out.println("Files.exists(p) = " + Files.exists(p));
        System.out.println("p = " + p);

        /*C:\Users\\user\\AppData\\Local\\Temp\\6100927974988978748.tmp.*/

        //createTempDir API:
        //To create Temporary Directory
    }

    //Deleting a File:
    public static void deleteFileUsingPath() throws IOException {
        //delete API:
        //If a file is not existent in file system, delete operation will fail with an IOException.

        Path p = Paths.get(HOME + "/FileToDelete.txt");
        if (!Files.exists(p)) Files.createFile(p);

        System.out.println("Files.exists(p) = " + Files.exists(p));
        Files.delete(p);
        System.out.println("Files.exists(p) = " + Files.exists(p));
    }

    public static void nonexistentFileDeleteIfExists() throws IOException {
        // deleteIfExists API:
        Path p = Paths.get(HOME + "/Nonexistent.txt");
        System.out.println("Files.exists(p) = " + Files.exists(p));

        Files.deleteIfExists(p);
    }

    public static void failsToDeleteNonEmptyDir() throws IOException {

        Path dir = Paths.get(HOME + "/emptyDir" + UUID.randomUUID());
        Files.createDirectory(dir);
        System.out.println("Files.exists(p) = " + Files.exists(dir));

        Path file = dir.resolve("File.txt");
        Files.createFile(file); //Making non-Empty directory

        Files.delete(dir);
        System.out.println("Files.exists(dir) = " + Files.exists(dir));
    }

    //Copying Files:
    public static void givenPathCopiesToNewLocation() throws IOException {
        Path d1 = Paths.get(HOME + "/FirstDir_" + UUID.randomUUID());
        Path d2 = Paths.get(HOME + "/OtherDir_" + UUID.randomUUID());

        Files.createDirectory(d1);
        Files.createDirectory(d2);

        Path file1 = d1.resolve("FileToCopy.txt");
        Path file2 = d2.resolve("FileToCopy.txt");

        Files.createFile(file1);

        System.out.println("Files.exists(file1) = " + Files.exists(file1));
        System.out.println("Files.exists(file2) = " + Files.exists(file2));

        //copy API
        //NOTE: Copy fails if the Target file exits unless the REPLACE_EXISTING option is specified

        Files.copy(file1, file2);
        System.out.println("Files.exists(file2) = " + Files.exists(file2));

    }

    public static void whenCopyFailsDueToExistingFile() throws IOException {

        Path dir1 = Paths.get(HOME + "/FirstDir_" + UUID.randomUUID());
        Path dir2 = Paths.get(HOME + "/OtherDir_" + UUID.randomUUID());

        Files.createDirectory(dir1);
        Files.createDirectory(dir2);

        Path file1 = dir1.resolve("FileToCopy.txt");
        Path file2 = dir2.resolve("FileToCopy.txt");

        Files.createFile(file1);
        Files.createFile(file2);

        System.out.println("Files.exists(file1) = " + Files.exists(file1));
        System.out.println("Files.exists(file2) = " + Files.exists(file2));

        Files.copy(file1, file2);

        Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING);
    }

    //Moving Files
    public static void givenPathMovesToNewLocation() throws IOException {
        //move API

        Path dir1 = Paths.get(HOME + "/FirstDir_" + UUID.randomUUID());
        Path dir2 = Paths.get(HOME + "/OtherDir_" + UUID.randomUUID());

        Files.createDirectory(dir1);
        Files.createDirectory(dir2);

        Path file1 = dir1.resolve("FileToCopy.txt");
        Path file2 = dir2.resolve("FileToCopy.txt");

        Files.createFile(file1);
        //Files.createFile(file2);

        System.out.println("Files.exists(file1) = " + Files.exists(file1));
        System.out.println("Files.exists(file2) = " + Files.exists(file2));

        Files.move(file1, file2);

        //Files.move(file1, file2, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Files.exists(file1) = " + Files.exists(file1));
        System.out.println("Files.exists(file2) = " + Files.exists(file2));
    }
}
