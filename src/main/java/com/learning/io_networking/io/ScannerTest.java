package com.learning.io_networking.io;

import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws IOException {
        //console input using Scanner
        Scanner sc = new Scanner(System.in);

        //Scanner(Readable source)
        //new Scanner(InputStream source)
        //new Scanner(File source)
        //new Scanner(Path source)
        //new Scanner(ReadableByteChannel source)


        System.out.println("Enter your roll no");
        int rollNo = sc.nextInt();
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your fee");
        double fee = sc.nextDouble();
        System.out.println("Roll no:" + rollNo + " name:" + name + " fee:" + fee);
        sc.close();

    }
}
