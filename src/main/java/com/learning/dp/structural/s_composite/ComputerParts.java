package com.learning.dp.structural.s_composite;

import java.util.ArrayList;
import java.util.List;

public class ComputerParts {
}

interface Component {
    void price();
}

class Leaf implements Component {

    String name;
    long price;

    public Leaf(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void price() {
        System.out.println(name + " : " + price);
    }
}

class Composite implements Component {

    String name;

    public Composite(String name) {
        this.name = name;
    }

    List<Component> comps = new ArrayList<>();
    public void addComponent(Component comp) {
        comps.add(comp);
    }

    @Override
    public void price() {
        System.out.println(name);
        for (Component c : comps) {
            c.price();
        }
    }
}
