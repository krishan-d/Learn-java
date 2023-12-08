package com.learning.basics_and_collections.generics;

import java.util.*;

//1. Generic class
class Box<T> {
    private T n;

    public void add(T n) {
        this.n = n;
    }

    public T get() {
        return n;
    }
}

//3. Generic Types:
/*
* E - Element (used extensively by java Collections Framework such as ArrayList)
* K - Key (Used in Map)
* V - Value
* N - Number
* T - Type
* S, U, V - 2nd, 3rd, 4th types
* */


//Generic class using Parameterized Types
class Trunk<T, S> {
    private T t;
    private S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getFirst() {
        return t;
    }

    public S getSecond() {
        return s;
    }
}

class Animal {
}

class Cat extends Animal {
}

class RedCat extends Cat {
}

class Dog extends Animal {
}
