import java.util.*;
public class DAA3knapGreedy {
    static class Item {
        int weight, value;
        Item(int w, int v) { weight = w; value = v; }
    }
    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int capacity = 50;

        long start = System.nanoTime(); 

        Arrays.sort(items, (a, b) -> {
            double ratio1 = (double) a.value / a.weight;
            double ratio2 = (double) b.value / b.weight;
            return Double.compare(ratio2, ratio1); 
        });

        double totalValue = 0;
        for (Item i : items) {
            if (capacity >= i.weight) {
                capacity -= i.weight;
                totalValue += i.value;
            } else {
                totalValue += i.value * ((double)capacity / i.weight);
                break;
            }
        }

        long end = System.nanoTime(); 

        System.out.println("Maximum value = " + totalValue);
        System.out.println("Execution Time: " + (end - start) / 1e6 + " ms");
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Space Complexity: O(1)");
    }
}
