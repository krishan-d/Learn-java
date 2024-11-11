package com.learning._11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Basics {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        // Nest-Based Access Control (JEP 181)
        // *** Local-Variable Syntax for Lambda Parameters (JEP 323)
        // *** HTTP Client API (JEP 321)
        // Flight Recorder (JEP 328)
        // Epsilon Garbage Collector (JEP 319)
        // Packaging for Native Images (JEP 340)
        // Removal of Java EE and CORBA Modules (JEP 212)
        // Simplified Class Data Sharing (JEP 323)
        // Improved Startup Performance
        // No-Op Garbage Collector (Epsilon GC)


        // 1. Local-Variable Syntax for Lambda Parameters:
        // You can make use of var for lambda arguments in Java 11.

        Calculator sum1 = (int a, int b) -> a + b;
        sum1.calc(10, 10);

        // Improvements
        Calculator sum2 = (var a, var b) -> a + b;
        sum2.calc(10, 10);



        // 2. HTTP Client:
        // The HTTP client was first introduced in Java 9, but it became a part of Java 11.

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.google.com/"))
                .GET()
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());



        // 3. String Methods:
        // Java 11 added a bunch of new methods to the String class, like “isBlank”, “strip”, “stripLeading”, and “stripTrailing”,
        // which make it a lot easier to do all the stuff you usually do with strings.

        String str1 = "";
        System.out.println(str1.isBlank()); // True

        String str = "Hi\nEve\n!";
        System.out.println(str.lines().collect(Collectors.toList()));
        // Hi
        // Eve
        // !

        String str2 = "1".repeat(5);
        System.out.println(str2); // 11111

        System.out.println("   hi  ".strip());
        System.out.println("   hi  ".stripLeading());
        System.out.println("   hi  ".stripTrailing());
        // "hi"
        // "hi  "
        // "   hi"



        // 4. New File Methods
        // Using these readString and writeString static methods from the Files class,
        // Java 11 aims to reduce a lot of boilerplate code which makes much easier to read and write files.
        Path tempDir = Paths.get("");
        Path filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample text");

        String fileContent = Files.readString(filePath);



        // 5. The Not Predicate Method
        // A static not method has been added to the Predicate interface. We can use it to negate an existing predicate,
        // much like the negate method:

        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List withoutBlanks = sampleList.stream()
            .filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());



    }
}

