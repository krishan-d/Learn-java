package com.learning.design_patterns.adapter_dp;

public class AssignmentWork {
    private Pen p;

    public Pen getP() {
        return p;
    }

    public void setP(Pen p) {
        this.p = p;
    }
    public void writeAssignment(String s) {
        p.write(s);
    }
}