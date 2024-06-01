package gfg;
// import java.util.*;


import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        return Double.compare(r2, r1); // Simplified comparison
    }
}

class FractionalKnapsack {
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator()); // Sorting items by value-to-weight ratio

        int curWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double) arr[i].value / arr[i].weight) * remain;
                break;
            }
        }

        return finalValue;
    }

}