package com.lab3;

public interface Item {
    String getName();
    int getValue();
    int getWeight();
    default double profitFactor() {
        return (double) getValue() / getWeight();
    }
    static int compareByName(Item item1, Item item2) {
        return item1.getName().compareTo(item2.getName());
    }
    static int reverseCompareByValue(Item item1, Item item2) {
        return (-1) * (item1.getValue() - item2.getValue());
    }
    static int compareByWeight(Item item1, Item item2) {
        return item1.getWeight() - item2.getWeight();
    }
}
