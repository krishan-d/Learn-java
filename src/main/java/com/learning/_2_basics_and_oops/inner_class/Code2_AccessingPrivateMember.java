package com.learning._2_basics_and_oops.inner_class;

class Outer_Demo1 {
    private int num = 100;
    class Inner_Demo {
        public int getNum() {
            System.out.println("This is getNum() of inner class!");
            return num;
        }
    }
}
public class Code2_AccessingPrivateMember {

    public static void main(String[] args) {
        Outer_Demo1 outer = new Outer_Demo1();
        Outer_Demo1.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}
