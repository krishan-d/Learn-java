package com.learning.misc_advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    public static void main(String[] args) {
        String input = "gmail.com";

        Pattern p = Pattern.compile("^\\.|^\\@");
        Matcher m = p.matcher(input);
        if (m.find())
            System.out.println("Email addresses don't start with dot or @ sign!");

        p = Pattern.compile("^www\\.");
        m = p.matcher(input);
        if (m.find())
            System.out.println("Email addresses don't start with \"www.\", only web pages do.");

        p = Pattern.compile("[^a-zA-Z\\d\\.\\@_\\-~#]+");
        m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        boolean result = m.find();
        boolean deletedIllegalChars = false;

        while (result) {
            deletedIllegalChars = true;
            m.appendReplacement(sb, "");
            result = m.find();
        }
        //Add last segment of input to the new string
        m.appendTail(sb);

        input = sb.toString();
        if (deletedIllegalChars)
            System.out.println("It contained incorrect characters, such as space or comma.");


        //OR
        String emailRegex = "";
        //String gmailRegex = "^[a-z0-9](\\.?[a-z0-9]){5,}@gmail\\.com$";
        String gmailRegex = "^([a-zA-Z\\d]+)([_.\\-{1}])?([a-zA-Z\\d]+)@([a-zA-Z\\d]+)([.])([a-zA-Z.]+)\\$";
        String email = "kris.k@gmail.com";
        Pattern pattern = Pattern.compile(gmailRegex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            System.out.println("VALID");
        } else System.out.println("INVALID");

    }
}
