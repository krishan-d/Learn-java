package com.learning.functionalprogramming;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

interface FunctionWithThrows<T, R, E extends Exception> {
    R apply(T type) throws E;
}

public class FPExceptionInLambda {
    public static void main(String[] args) {
        String url = "www.google.com";
        System.out.println(encodedAddress(url));
    }

    static String encodedAddress(String... address) {
        /*
        return Arrays.stream(address)
                .map(s - > URLEncoder.encode(s, "UTF-8")) // UnsupportedEncodingException
                .collect(Collectors.joining(","));
                */

        /*
        return Arrays.stream(address)
                .map(FPExceptionInLambda::encodedString).collect(Collectors.joining(","));
                */

        //OR
        //Functional interface and wrapper method
        return Arrays.stream(address)
                .map(wrapper(s -> URLEncoder.encode(s, "UTF-8")))
                .collect(Collectors.joining(","));

    }

    //Extracting URLEncoder.encode() in a separate method.
    static String encodedString(String s) {
        try {
            URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    //Above approach is not good when we have multiple such methods which throws exception.
    //Generalized solution using functional interface and a wrapper method.
    private static <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithThrows<T, R, E> f) {
        return arg -> {
            try {
                return f.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        };
    }
}
