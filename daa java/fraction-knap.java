import java.util.Arrays;
import java.util.Comparator;

class Item {
    double profit, weight;

    // Constructor
    public Item(double profit, double weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Main greedy function to solve the problem
    public static double fractionalKnapsack(double W, Item[] arr) {
        // Sorting items on the basis of profit-to-weight ratio
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                double r1 = i1.profit / i1.weight;
                double r2 = i2.profit / i2.weight;
                return Double.compare(r2, r1); // Sort in descending order
            }
        });

        double finalValue = 0.0; // Result (value in knapsack)

        // Looping through all items
        for (Item item : arr) {
            // If adding the item won't overflow, add it completely
            if (item.weight <= W) {
                W -= item.weight;
                finalValue += item.profit;
            } 
            // If we can't add current item, add fractional part of it
            else {
                finalValue += item.profit * W / item.weight;
                break;
            }
        }

        // Returning final value
        return finalValue;
    }

    // Driver Code
    public static void main(String[] args) {
        double W = 50; // Maximum weight of knapsack
        Item[] arr = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };

        // Function call
        double maxVal = fractionalKnapsack(W, arr);
        System.out.println("Maximum profit in knapsack = " + maxVal);
    }
}
