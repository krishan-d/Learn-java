package com.learning.design_patterns.composite_dp;

//Composite Design Pattern : Structure Design pattern
public class CompositeTest {

    public static void main(String[] args) {

        Component hd = new Leaf("Hdd", 5000);
        Component mouse = new Leaf("Mouse", 1000);
        Component monitor = new Leaf("Monitor", 8000);
        Component ram = new Leaf("RAM", 4000);
        Component cpu = new Leaf("CPU", 10000);

        Composite ph = new Composite("peri");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("MB");
        Composite comp = new Composite("Computer");

        mb.addComponent(cpu);
        mb.addComponent(ram);

        ph.addComponent(mouse);
        ph.addComponent(monitor);

        cabinet.addComponent(hd);
        cabinet.addComponent(mb);

        comp.addComponent(ph);
        comp.addComponent(cabinet);

        ph.price();
    }
}
