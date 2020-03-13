package com.lab3;

import java.util.List;

public class DynamicProgrammingAlgorithm extends KnapsackAlgorithm {
    private int[][] m;

    public DynamicProgrammingAlgorithm(Knapsack knapsack, List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
        m = new int[items.size() + 1][knapsack.getCapacity() + 1];
    }

    /**
    * Varianta de programare dinamica a acestui algoritm are la baza o matrice care se compune astfel:
    * m[i][j] = valoarea maxima care poate fi obtinuta adaugandu-se primele (o parte nu neaparat toate) i obiecte (sortate 
    * dupa masa) intr-un rucsac cu capacitatea j. Astfel o sa stim ca intotdauna dupa ce construim aceasta matrice, pe pozitia 
    * m[nr_max_obj][cap_max_rucsac] se va afla valoarea maxima a obiectelor ce pot fi adaugate in rucsac. Pentru a obtine 
    * si o lista cu aceste obiecte pornim de la aceasta valoare maxima si verificam daca ea se regaseste pe linia i - 1. Daca
    * NU se regaseste atunci obiectul reprezentat de linia curenta face parte din rucsac altfel continuam cautarea pe liniile
    * anterioare.
    */
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
