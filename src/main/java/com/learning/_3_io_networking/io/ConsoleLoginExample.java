package com.learning._3_io_networking.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleLoginExample {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.out.println("Console is not supported");
            System.exit(1);
        }

        String name = console.readLine("Enter your name: ");
        char[] password = console.readPassword("Enter your password: ");

        char[] correctPassword = {'n', 'i', 'm', 'd', 'a'};

        if (Arrays.equals(password, correctPassword)) {
            console.printf("Thanks %s, you are logged in.\n", name);
        } else {
            console.printf("Sorry, you are denied.\n");
        }

        Arrays.fill(password, ' ');
        Arrays.fill(correctPassword, ' ');
    }
}
