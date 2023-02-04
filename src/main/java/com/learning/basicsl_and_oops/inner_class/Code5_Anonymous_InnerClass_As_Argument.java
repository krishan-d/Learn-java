package com.learning.basicsl_and_oops.inner_class;

interface Message {
    String greet();
}

public class Code5_Anonymous_InnerClass_As_Argument {

    public void displayMessage(Message m) {
        System.out.println(m.greet() + ", This is anonymous class as argument!");
    }

    public static void main(String[] args) {
        Code5_Anonymous_InnerClass_As_Argument ob = new Code5_Anonymous_InnerClass_As_Argument();

        ob.displayMessage(() -> "Hello");
    }
}
