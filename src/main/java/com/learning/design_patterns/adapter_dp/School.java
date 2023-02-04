package com.learning.design_patterns.adapter_dp;

public class School {

    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork aw = new AssignmentWork();
        aw.setP(p);
        aw.writeAssignment("This is assignment !");
    }
}
