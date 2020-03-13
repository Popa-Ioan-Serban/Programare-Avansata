package com.lab4;


public class Resident {
    private String name;

    public Resident(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o1) {
        if (!(o1 instanceof Resident)) return false;
        return name.equals(((Resident) o1).getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
