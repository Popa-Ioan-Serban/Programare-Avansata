package com.lab3;

import java.util.List;
import java.util.ArrayList;

public class ProblemGenerator {
    private int knapsackCapacity;
    private int minKnapsackCapacity;
    private int maxKnapsackCapacity;
    private int minNumberOfItems;
    private int minWeight;
    private int maxWeight;
    private Knapsack knapsack;
    private List<Item> items;


    public ProblemGenerator() {
        minKnapsackCapacity = 10;
        maxKnapsackCapacity = 50;
        minNumberOfItems = 1;
        minWeight = 1;
        knapsackCapacity = maxKnapsackCapacity;
    }

    public ProblemGenerator(int minKnapsackCapacity, int maxKnapsackCapacity, int minNumberOfItems, int minWeight, int maxWeight) {
        this.minKnapsackCapacity = minKnapsackCapacity;
        this.maxKnapsackCapacity = maxKnapsackCapacity;
        this.minNumberOfItems = minNumberOfItems;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        knapsackCapacity = maxKnapsackCapacity;
    }

    private void generateKnapsack() {
        knapsack = new Knapsack((int) (Math.random() * (maxKnapsackCapacity - minKnapsackCapacity + 1) + minKnapsackCapacity));
    }

    private void generateItemList() {
        knapsackCapacity = knapsack.getCapacity();
        int maxNumberOfItems = knapsackCapacity / 3;
        int numberOfItems = (int) (Math.random() * (maxNumberOfItems - minNumberOfItems + 1) + minNumberOfItems);
        int type, weight, value;
        int noOfBooks = 0;
        int noOfFood = 0;
        maxWeight = knapsackCapacity / 2;

        items = new ArrayList<>(numberOfItems);

        for (int i = 0; i < numberOfItems; i++) {
            weight = (int) (Math.random() * (maxWeight - minWeight + 1) + minWeight);
            value = (int) (Math.random() * (maxWeight - minWeight + 1) + minWeight);

            type = (int) (Math.random() * 2 + 1);

            switch (type) {
                case 1: {
                    noOfBooks++;
                    items.add(new Book("book" + Integer.toString(noOfBooks), 100 * weight, value));
                    break;
                }
                case 2: {
                    int weaponTypeIndex = (int) (Math.random() * 2 + 1);
                    switch (weaponTypeIndex) {
                        case 0: {
                            items.add(new Weapon(WeaponType.Sword, weight, value));
                            break;
                        }
                        case 1: {
                            items.add(new Weapon(WeaponType.Knife, weight, value));
                            break;
                        }
                        default: {
                            items.add(new Weapon(WeaponType.Pistol, weight, value));
                        }
                    }
                }
                default: {
                    noOfFood++;
                    items.add(new Food("food" + Integer.toString(noOfFood), weight));
                    break;
                }
            }
        }
    }

    public void generateInstance() {
        generateKnapsack();
        generateItemList();
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public List<Item> getItems() {
        return items;
    }

}
