package com.lab3;

import java.util.Iterator;
import java.util.List;

public class GreedyAlgorithm extends KnapsackAlgorithm {
    public GreedyAlgorithm(Knapsack knapsack, List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
    }

    public void computeSolution() {
        items.sort(Item::reverseCompareByValue);

        Iterator<Item> listIterator = items.iterator();

        while (listIterator.hasNext() && knapsack.isEnoughSpace()) {
            knapsack.addItem(listIterator.next());
        }
    }

    public String getSolution() {
        return knapsack.toString();
    }
}
