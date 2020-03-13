package com.lab3;

import java.util.List;

public class DynamicProgrammingAlgorithm extends KnapsackAlgorithm {
    private int[][] m;

    public DynamicProgrammingAlgorithm(Knapsack knapsack, List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
        m = new int[items.size() + 1][knapsack.getCapacity() + 1];
    }

    public void computeSolution() {
        items.sort(Item::compareByWeight);

        int itemWeight;
        int knapsackCapacity = knapsack.getCapacity();

        for (int i = 1; i < items.size() + 1; i++) {
            for (int j = 1; j < knapsackCapacity + 1; j++) {
                itemWeight = items.get(i - 1).getWeight();
                if (itemWeight > j)
                    m[i][j] = m[i - 1][j];
                else
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - itemWeight] + items.get(i - 1).getValue());
            }
        }

        int currentValue = m[items.size()][knapsackCapacity];
        int i = items.size();
        boolean existAbove;

        while (i >= 1) {
            existAbove = false;
            for (int j = 0; j < knapsackCapacity; j++) {
                if (m[i - 1][j] == currentValue) {
                    existAbove = true;
                    break;
                }
            }

            if (!existAbove) {
                currentValue -= items.get(i - 1).getValue();
                knapsack.addItem(items.get(i - 1));
            }
            i--;
        }
    }

    public String getSolution() {
        return knapsack.toString();
    }
}
