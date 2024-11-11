package com.learning.dp.structural.s_adapter;

public class School {

    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork aw = new AssignmentWork();
        aw.setP(p);
        aw.writeAssignment("This is assignment !");
    }
}
