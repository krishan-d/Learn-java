package com.learning._3_io_networking.io.core_io_0;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenameMoveFile {

    private static final String FILE_TO_MOVE = "src/main/resources/originalFileToMove.txt";
    private static final String TARGET_FILE = "src/main/resources/TargetFileToMove.txt";

    public static void main(String[] args) throws IOException {

        movingFileUsingNioFilesAndPaths();
    }

    //Helper Methods
    public static void createFileToMove() throws IOException {
        File moveFile = new File(FILE_TO_MOVE);
        boolean newFile = moveFile.createNewFile();
    }

    public static void cleanupFiles() {
        File targetFile = new File(TARGET_FILE);
        targetFile.delete();
    }

    public static void movingFileUsingNioFilesAndPaths() throws IOException {

        Path fileToMovePath = Paths.get(FILE_TO_MOVE);
        Path targetPath = Paths.get(TARGET_FILE);

        Files.move(fileToMovePath, targetPath);
    }

    public static void moveFileUsingFileClass() throws FileSystemException {

        File fileToMove = new File(FILE_TO_MOVE);
        boolean isMoved = fileToMove.renameTo(new File(TARGET_FILE));
        if (!isMoved) { throw new FileSystemException(TARGET_FILE);
        }
    }

    public static void moveFileUsingCommonsIo() throws IOException {

        //Allows both moving and renaming, depending on if the target directory is the same or not.

        FileUtils.moveFile(FileUtils.getFile(FILE_TO_MOVE), FileUtils.getFile(TARGET_FILE));
        FileUtils.getFile(TARGET_FILE);
        //or
        //
        FileUtils.moveFileToDirectory(FileUtils.getFile(FILE_TO_MOVE), FileUtils.getFile("src/test/resources/"), true);
    }
}
