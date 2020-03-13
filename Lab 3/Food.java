package com.lab3;

public class Food implements Item {
    private String name;
    private int weight;


    public Food(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getValue() {
        return weight * 2;
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append(name).append(", ").append("weight = ").append(weight).append(", ").append("value = ").append(getValue());
        return obj.toString();
    }
}
