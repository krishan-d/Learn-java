package com.learning._3_io_networking.io.core_io_0.char_stream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharacterStreams {
    static final String INPUT_FILE = "data_directory//input.txt";
    static final String OUTPUT_FILE = "data_directory//output.txt";
    static final String FILE_NAME = "data_directory//char_stream.txt";

    public static void main(String[] args) throws IOException {
        // Reading console input using InputStreamReader
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter something...");
        char c = (char) br.read();  // Reading character
        System.out.println("character: " + c);

        String text = br.readLine(); // Reading String
        System.out.println("readLine: " + text);


        try (InputStreamReader cin = new InputStreamReader(System.in)) {
            System.out.println("Enter characters, q to quit!");
            char ch;
            do {
                ch = (char) cin.read();
                System.out.println(ch);
            } while (ch != 'q');
        }
        */

        /*
         * Reader Methods:
         * ready(): checks if reader is ready to be read.
         * read(char[] array): reads from stream and stores in specified array
         * mark()
         * reset()
         * skip()
         * */

        /*
         * Writer : Abstract class for writing to character streams.
         *
         * Methods:
         * write(char[] array): writes characters from specified array to output stream
         * write(String data): writes specified string to writer
         * append(char c): insert specified character to current writer
         * append(CharSequence csq):
         * flush(): Forces to write all data present in writer to destination
         *
         * Note:
         * Interface CharSequence: readable sequence of char values.
         * Implementing Classes: CharBuffer, Segment, String, StringBuffer, StringBuilder
         * */
        char[] array = new char[100];
        String data = "Hi Krishna!\nHope you are well.\nThanks";

        try (Writer output = new FileWriter(FILE_NAME); Reader input = new FileReader(FILE_NAME);) {

            output.write("#");
            output.write(data);
            output.append("\nThis is another Line!");

            output.close();

            // Checks if reader is ready
            System.out.println("Is reader ready: " + input.ready());

            input.read();
            input.read(array);  // Reads characters
            System.out.println(new String(array));
            input.close();
        } catch (Exception ignored) {
        }

        /*
         * OutputStreamWriter:
         * */

        try {
            FileOutputStream file = new FileOutputStream(OUTPUT_FILE);
            OutputStreamWriter output = new OutputStreamWriter(file, StandardCharsets.UTF_8);

            output.write(1); // writes a single character
            output.write("This is a Line inside!");
            output.write(new char[3]);
            output.close();

        } catch (Exception ignored) {
        }

        /*
         * InputStreamReader: Translate byte to character
         * */
        char[] array1 = new char[100];
        try {
            FileInputStream file = new FileInputStream(INPUT_FILE);
            InputStreamReader input1 = new InputStreamReader(file); // default encoding

            InputStreamReader input2 = new InputStreamReader(file, StandardCharsets.UTF_16);

            // Encoding
            System.out.println("Default Encoding: " + input1.getEncoding());
            System.out.println("Encoding: " + input2.getEncoding());

            input1.read(array1);
            System.out.println(array1);

            input1.close();
            input2.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        /*
         * FileReader: read data from files
         * */
        char[] array2 = new char[100];
        try {
            FileReader in = new FileReader(INPUT_FILE);

            int i = in.read();
            System.out.println(i);
            in.read(array2);
            System.out.println(array2);
            in.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        /*
         * FileWriter: writes data to files
         * */
        try (FileWriter output = new FileWriter(OUTPUT_FILE)) {
            String encoding = output.getEncoding();
            System.out.println(encoding);
            output.write("This is a line, added to output file.");
            output.close();
        }

        //Copying File data
        try (FileReader in = new FileReader(INPUT_FILE); FileWriter out = new FileWriter(OUTPUT_FILE)) {
            int c;
            while ((c = in.read()) != -1) {
                //out.write(c);
                out.append((char) c);
            }
        }
    }
}
