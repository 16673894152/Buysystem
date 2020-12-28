package com.lzr.vo;

import java.util.List;

public class Tongji {
    private String name;
    private int value;
    private List<String> names;
    public Tongji(){}


    public String getName() {
        return name;
    }

    public Tongji(String name, int value, List<String> names) {
        this.name = name;
        this.value = value;
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
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

    @Override
    public String toString() {
        return "Tongji{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", names=" + names +
                '}';
    }
}
