package com.learning._1_basics.mine;

interface Demo {
}

final class A {
}

//class B extends A { } //CTE

class SuperClass implements Demo {
    //int x = 10;
    int x;
    final int y = 100;
    final int z;
    static final int data;

    static {
        data = 40;
    }

    int v = 20;

    SuperClass() {
        System.out.println("SuperClass default constructor...");
        z = 0;
    }

    SuperClass(int x) {
        this.x = x;
        System.out.println("SuperClass parameterized constructor...");
        z = 0;
    }

    void method1() {
        System.out.println("SuperClass Method1...");
    }

    void method2() {
        System.out.println("SuperClass Method2... " + x);
    }

    SuperClass get() {
        return this;
    }


    final void method3() {
        System.out.println("SuperClass Method3...");
    }

    //Note: private and static methods can not be overridden
    //Method hiding
    private void method5() {
        System.out.println("SuperClass private Method5...");
    }

    //Compile time polymorphism
    static void method6() {
        System.out.println("SuperClass Method6...");
    }

    static void method6(int data) {
        System.out.println("SuperClass Method6..." + data);
    }

    protected void method7() {
        System.out.println("SuperClass protected Method7...");
    }
}

public class OopTesting extends SuperClass {
    //int x = 20;
    int v = 10;

    OopTesting() {
        // super();
        System.out.println("OopTesting default constructor...");
    }

    OopTesting(int x) {
        super(x);
        System.out.println("Child class constructor invoked! : " + this.x);
    }

    void method1() {
        System.out.println("OopTesting Method1...");
    }

    void my_method() {
        OopTesting inner = new OopTesting();
        inner.method1();

        super.method1();
        System.out.println(inner.v);
        System.out.println(super.v);
    }

    OopTesting get() {
        return this;
    }


    void message() {
        System.out.println("Method overriding by covariant return type!");
    }


    //initializer block
    {
        x = 17;
        System.out.println("instance initializer block is invoked!");
    }

    //void method3() { System.out.println("OopTesting Method3..."); } //CTE

    void method4(final int n) {// n = n + 2; //CTE
    }

    private void method5() {
        System.out.println("OopTesting Method5...");
    }

    //void method6() {} //CTE

    //void method7() { System.out.println("OopTesting protected Method7..."); }  //CTE // more restrictive[protected -> default]
    //protected void method7() { System.out.println("OopTesting protected Method7..."); } // [protected -> protected]
    public void method7() {
        System.out.println("OopTesting public Method7...");
    } // [protected -> public]

    public static void main(String[] args) {

        OopTesting oop = new OopTesting();
        oop.method1(); // static binding
        oop.method5();
        oop.method7();

        new OopTesting(27).method2(); //Anonymous instance object

        oop.my_method();

        SuperClass superObj = new SuperClass();
        superObj.method1();
        System.out.println(oop instanceof Demo);
        System.out.println(oop instanceof SuperClass);
        System.out.println(superObj instanceof Demo);
        System.out.println(superObj instanceof OopTesting); //False
        //superObj.method5(); //CTE
        superObj.method7();


        new OopTesting().get().message();


        SuperClass superObj1 = new OopTesting(); //Upcasting
        //superObj1.message(); //ERROR
        superObj1.method1(); //OopTesting Method1... //Runtime polymorphism or dynamic method dispatch // dynamic binding
        // call to method is resolved at runtime rather than compile time
        System.out.println("v [upcasting]: " + superObj1.v); // data members can not be overridden
        System.out.println("v [child class obj]: " + oop.v);
        System.out.println("v [super class obj]: " + superObj.v);
        //superObj1.method5(); //CTE
        superObj.method7();  //SuperClass protected Method7...

        // oop.y = 200; //CTE

        new OopTesting().method3(); //final method can not be overridden


    }

    public static void main() {
        System.out.println("Overriding main method!!");
    }

}
