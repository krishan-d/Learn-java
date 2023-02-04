/*
 * Find digit in alphanumeric string
 * */
package com.learning.misc_advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    /*
     * Regular Expression:
     * A regular expression is a pattern of characters that describes a set of strings.
     *
     * Metacharacter:
     * |	    A|B  Matches either A or B
     * .	    Find just one instance of any character
     * ^	    Finds a match as the beginning of a string as in: ^Hello
     * $	    Finds a match at the end of the string as in: World$
     *
     * Quantifier:
     * X?	X occurs once or NOT
     * X+	X occurs once or more times
     * X*	X occurs zero or more times
     * X{n}	X occurs n times only
     * X{n,}	X occurs n or more times
     * X{n,m}	X occurs at least n and at most m times
     *
     * Characters:
     * x	    The character x
     * \\	The backslash character
     * \0n	The character with octal value 0n (0 <= n <= 7)
     * \0nn	The character with octal value 0nn (0 <= n <= 7)
     * \0mnn	The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)
     * \xhh	The character with hexadecimal value 0xhh
     * \t	The tab character ('\u0009')
     * \n	The newline (line feed) character ('\u000A')
     * \r	The carriage-return character ('\u000D')
     * \f	The form-feed character ('\u000C')
     * \a	The alert (bell) character ('\u0007')
     * \e	The escape character ('\u001B')
     * \cx	The control character corresponding to x
     *
     * Character Classes:
     * [abc]	    Find one character from the options between the brackets: a, b or c(simple class)
     * [^abc]	Find one character NOT between the brackets: character except a, b or c(negation)
     * [0-9]	    Find one character from the range 0 to 9
     * [a-z-[bc]]	a through z, except for b and c: [ad-z]
     * [a-z-[m-p]]	a through z, except for m through p: [a-lq-z]
     * [a-z-[^def]]	d, e or f
     * (X)   Group regular expression and remember matched text.
     * (?:X) Group regex without remembering matched text.
     * (?>X) Matches independent pattern without backtracking.
     *
     * Predefined Character Classes:
     * .	    Any character (may or may not match line terminators)
     * \d	A digit: [0-9]
     * \D	A non-digit: [^0-9]
     * \s	A whitespace character: [ \t\n\x0B\f\r]
     * \S	A non-whitespace character: [^\s]
     * \w	A word character: [a-zA-Z_0-9]
     * \W	A non-word character: [^\w]
     * \b   A word boundary
     * \B   A non word boundary
     * */

    // String to be scanned to find the pattern.
    private static final String INPUT = "This order was placed for QT3000! OK?";
    private static final String REGEX = "(.*)(\\d+)(.*)";

    public static void main(String[] args) {
        Pattern r = Pattern.compile(REGEX);
        Matcher m = r.matcher(INPUT);

        int groupCount = m.groupCount();
        System.out.println("Group Count = " + groupCount);

        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else System.out.println("NO MATCH");
    }
}
