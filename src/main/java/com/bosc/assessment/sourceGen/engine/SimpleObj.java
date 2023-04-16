package com.bosc.assessment.sourceGen.engine;

public class SimpleObj {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SimpleObj{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
