package com.lab3;

public class Book implements Item {
    private String name;
    private int pageNumber;
    private int value;


    public Book(String name, int pageNumber, int value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getWeight() {
        return pageNumber / 100;
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append(name).append(", ").append("weight = ").append(getWeight()).append(", ").append("value = ").append(value);
        return obj.toString();
    }
}
