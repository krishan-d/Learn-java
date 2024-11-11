package com.learning.dp.structural.s_adapter;

//Adapter Design Pattern:
import com.learning.dp.structural.s_adapter.pen.PilotPen;

public class PenAdapter implements Pen {

    PilotPen pp = new PilotPen();
    @Override
    public void write(String str) {
        pp.mark(str);
    }
}
