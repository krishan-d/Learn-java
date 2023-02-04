package com.learning.io_networking.io.noi_apis;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioPathApi {

    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {

        //Operations:

        //Creating a path
        Path home = Paths.get(HOME);
        if ("C:\\Users\\krish".equals(home.toString())) System.out.println("True");

        Path p1 = Paths.get("/Directory", "subDirectory");
        boolean b1 = "\\Directory\\subDirectory".equals(p1.toString());

        //getFileName API
        System.out.println(p1.getFileName());

        //subPath API
        Path subPath = p1.subpath(0, 1);
        System.out.println(subPath);

        Path p2 = Paths.get("/Directory/subDirectory/Logs");
        Path p3 = Paths.get("/Directory/subDirectory");
        Path p4 = Paths.get("/Directory");
        Path p5 = Paths.get("/");

        //getParent API
        System.out.println("/Directory/subDirectory/Logs Parent: " + p2.getParent().toString());
        System.out.println("/Directory/subDirectory Parent: " + p3.getParent().toString());
        System.out.println("/Directory Parent: " + p4.getParent().toString());
        System.out.println("/ Parent: " + p5.getParent()); //null

        //getRoot API
        Path root1 = home.getRoot();
        Path root2 = p2.getRoot();

        System.out.println("c:\\ : " + root1);
        System.out.println("\\ : " + root2);


        //normalize API:
        //"." notation to denote current directory and ".." to denote parent directory.
        //To remove redundancies in path. such as:
        p1 = Paths.get("/Directory/./subDirectory/Folder/File.html");
        p2 = Paths.get("/Directory/subDirectory/../Folder");

        Path cleanPath = p1.normalize();
        System.out.println("cleanPath [\\Directory\\subDirectory\\Folder\\File.html] = " + cleanPath);

        cleanPath = p2.normalize();
        System.out.println("cleanPath [\\Directory\\Folder] = " + cleanPath);

        //Path conversions
        //toUri API:
        //To convert any path into a string that can be opened from browser, use toUri() method
        p1 = Paths.get("/Directory/subDirectory/Folder/File.html");
        URI uri = p1.toUri();
        System.out.println("uri [file:///E:/Directory/subDirectory/Folder/File.html] = " + uri);

        //toAbsolutePath API:
        //Resolves a path against a file system default directory.
        //However, when path to be resolved is detected to be already absolute, method return it as it.
        Path absolutePath = p1.toAbsolutePath();
        System.out.println("absolutePath [E:\\Directory\\subDirectory\\Folder\\File.html] = " + absolutePath);

        //toRealPath() API:
        //If path does not exist in file system ,then operation will throw IOException.
        Path realPath = home.toRealPath();
        System.out.println("realPath = " + realPath);

        Path path = Paths.get("E:\\Directory\\subDirectory\\Folder\\File.html");
        //path.toRealPath(); // NoSuchFileException

        //Joining Paths
        //resolve API:
        p1 = Paths.get("/Directory/Articles");
        p2 = p1.resolve("Java");

        System.out.println("p2 [\\Directory\\Articles\\Java] = " + p2);

        p3 = p1.resolve("/Java");
        System.out.println("p3 [\\Java] = " + p3);

        p4 = p1.resolve("E:\\Directory\\Articles\\Java\\File.html");
        System.out.println("p4 [E:\\Directory\\Articles\\Java\\File.html] = " + p4);


        //Relativize Paths
        //Creating a direct path between two known paths.
        //For instance, We have a directory /Directory and inside it, we have two other directories,
        //Directory/Articles and Directory/Authors are valid paths.
        p1 = Paths.get("Articles");
        p2 = Paths.get("Authors");

        Path p1_rel_p2 = p1.relativize(p2);
        System.out.println("[..\\Authors] = " + p1_rel_p2);


        //Comparing paths:
        //p1_rel_p2.equals(p2.relativize(p1)); //True
        //home.startsWith("c:/");

    }
}
