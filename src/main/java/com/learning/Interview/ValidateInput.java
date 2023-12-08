package com.learning.Interview;

import java.util.Stack;

public class ValidateInput {
    public static void main(String[] args) {

        String s = "[(){()}]";
        System.out.println(s);

        boolean result = new ValidateInput().isValid(s);
        System.out.println(result);

//        System.out.println(Math.abs('[' - '['));

    }

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chArray = input.toCharArray();
        for (char ch : chArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']')  {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        for (char c : input.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else if (")}]".contains(String.valueOf(c))) {
                if (stack.isEmpty() || Math.abs(c - stack.pop()) > 2) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
