package com.learning.io_networking.io.core_io_1.listfiles;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.learning.io_networking.io.core_io_1.listfiles.ListFiles;

public class ListFilesTest {

    private ListFiles listFiles = new ListFiles();
    private String DIRECTORY = "src/test/resources/listFilesUnitTestFolder";
    private static final int DEPTH = 1;

    private Set<String> EXPECTED_FILE_LIST = new HashSet<String>() {
        {
            add("test.xml");
            add("employee.json");
            add("students.json");
            add("country.txt");
        }
    };

    @Test
    public void givenDir_whenUsingJAVAIO_thenListAllFiles() {
        Assert.assertEquals(EXPECTED_FILE_LIST, listFiles.listFilesUsingJavaIO(DIRECTORY));
    }

    @Test
    public void givenDir_whenUsingFilesList_thenListAllFiles() throws IOException {
        Assert.assertEquals(EXPECTED_FILE_LIST, listFiles.listFilesUsingFilesList(DIRECTORY));
    }
}