package com.learning.misc.regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveControlCharacter {
    public static void main(String[] args) throws IOException {
        //Create a file object with the file name in the argument:
        File fin = new File("fileName1");
        File f_out = new File("fileName2");

        //Open and input and output stream
        FileInputStream fis = new FileInputStream(fin);
        FileOutputStream fos = new FileOutputStream(f_out);

        BufferedReader b_reader = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter b_writer = new BufferedWriter(new OutputStreamWriter(fos));

        // The pattern matches control characters
        Pattern p = Pattern.compile("cntrl");
        Matcher m = p.matcher("");
        String aLine;
        while ((aLine = b_reader.readLine()) != null) {
            m.reset(aLine);
            //Replaces control characters with an empty string.
            String result = m.replaceAll("");
            b_writer.write(result);
            b_writer.newLine();
        }
        b_reader.close();
        b_writer.close();
    }
}
