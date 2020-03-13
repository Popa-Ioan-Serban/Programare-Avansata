package com.lab4;


public class Hospital implements Comparable<Hospital>{
    private String name;
    private int capacity;

    public Hospital(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int compareTo(Hospital h2) {
        return name.compareTo(h2.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
