package com.lab3;

import java.util.*;

public class Knapsack {
    private int capacity;
    private int totalWeight;
    private int totalValue;
    private List<Item> items = new ArrayList<>();


    public Knapsack(int capacity) {
        this.capacity = capacity;
        totalWeight = 0;
        totalValue = 0;
    }

    public void addItem(Item item) {
        if (item.getWeight() + totalWeight <= capacity) {
            totalWeight += item.getWeight();
            totalValue += item.getValue();
            items.add(item);
        }
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public boolean isEnoughSpace() {
        return totalWeight < capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setItems(List<Item> items) {
        int localTotalWeight = 0;
        int localTotalValue = 0;
        for (Item item: items) {
            localTotalWeight += item.getWeight();
            localTotalValue += item.getValue();
        }

        if (localTotalWeight > capacity)
            System.out.println("Lista de obiecte nu a putut fi adaugata in rucsac deoarece depaseste capacitatea!");

        totalWeight = localTotalWeight;
        totalValue = localTotalValue;
        this.items = items;
    }

    public List<Item> getItems() {
        if (items == null) return null;
        return new ArrayList<>(items);
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();

        if (items.size() == 0) {
            obj.append("(empty) ").append(" (total weight=").append(totalWeight).append(", ").append("total value=").append(totalValue).append(")");
        }
        else {
            items.sort(Item::compareByName);

            Iterator<Item> itemIterator = items.iterator();
            if (itemIterator.hasNext())
                obj.append(itemIterator.next().getName());

            while (itemIterator.hasNext())
                obj.append(", ").append(itemIterator.next().getName());

            obj.append(" (total weight=").append(totalWeight).append(", ").append("total value=").append(totalValue).append(")");
        }
        return obj.toString();
    }
}
