package com.learning.design_patterns.adapter_dp;

//Adapter Design Pattern:
import com.learning.design_patterns.adapter_dp.pen.PilotPen;

public class PenAdapter implements Pen {

    PilotPen pp = new PilotPen();
    @Override
    public void write(String str) {
        pp.mark(str);
    }
}
