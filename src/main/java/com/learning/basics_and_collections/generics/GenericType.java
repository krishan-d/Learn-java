package com.learning.basics_and_collections.generics;

public class GenericType<T> {

    private T val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public static void main(String[] args) {
        GenericType<String> ob = new GenericType<>();
        ob.setVal("Eve"); //valid

        GenericType ob1 = new GenericType<>();
        ob1.setVal(10); //valid
        ob1.setVal("Edwina"); //Valid and autoboxing support

    }
}
