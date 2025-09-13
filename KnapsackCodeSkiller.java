 
package DynamicProgramming;

public class KnapsackCodeSkiller {
    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 2, 2 };  // weights
        int[] values = { 8, 4, 0, 5, 3 };
        int capacity = 4;
        System.out.println(Knapsack(weight, values, capacity, 0));
    }

    private static int Knapsack(int[] weight, int[] values, int capacity, int idx) {
       
        if (capacity == 0 || idx == weight.length) {
            return 0;
        }
        if (idx == weight.length) {
            
        }
        int inc = 0, exc = 0;
        if (capacity >= weight[idx]) {
            inc = values[idx] + Knapsack(weight, values, capacity - weight[idx], idx + 1);
        }
        exc = Knapsack(weight, values, capacity, idx + 1);
        return Math.max(inc, exc);
    }
}
 