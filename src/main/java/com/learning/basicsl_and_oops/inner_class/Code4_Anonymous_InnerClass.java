package com.learning.basicsl_and_oops.inner_class;

abstract class AnonymousInner {
    public abstract void my_method();
}

public class Code4_Anonymous_InnerClass {

    public static void main(String[] args) {

        AnonymousInner inner = new AnonymousInner() {
            @Override
            public void my_method() {
                System.out.println("This is anonymous inner class!");
            }
        };
        inner.my_method();
    }
}
