package com.learning.logging_hell;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerRunner {

    private static final Logger logger  = Logger.getLogger(LoggerRunner.class.getName());

    public static void main(String[] args) {
        if (logger == null) return;

        logger.setLevel(Level.INFO);

        List<Integer> integerList = List.of(1, 7, 4, 4, 0);

        List<Integer> sortedList = integerList.stream().sorted().toList();
        logger.info(sortedList.toString());
    }
}
