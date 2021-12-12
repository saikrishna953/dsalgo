package com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        fractionalKnapsack.getItems(items);

        double maxValue = fractionalKnapsack.findMaximumValue(items, 50);
        System.out.println("Maximum Value:" + maxValue);

    }

    private double findMaximumValue(List<Item> items, int W) {

        Collections.sort(items, (o1, o2) -> {
            double r1 = (double) o1.value / (double) o1.weight;
            double r2 = (double) o2.value / (double) o2.weight;
            if (r1 > r2) {
                return -1;
            } else if (r1 < r2) {
                return 1;
            } else {
                return 0;
            }
        });

        double maxValue = 0;
        int currWeight = 0;

        for (int i = 0; i < items.size(); i++) {
            if ((currWeight + items.get(i).weight) <= W) {
                currWeight += items.get(i).weight;
                maxValue += items.get(i).value;
            } else {
                int remain = W - currWeight;
                maxValue += ((double) items.get(i).value / (double) items.get(i).weight) * (double) remain;
                break;
            }
        }

        return maxValue;
    }

    private void getItems(List<Item> items) {
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));
    }

    class Item {
        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
