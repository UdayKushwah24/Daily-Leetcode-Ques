package DynamicProgramming;

import java.util.Scanner;

public class Knapsack_0_1 {
    
    /*
     * public static void main(String[] args) {
     * int[] weight = { 1, 2, 3, 2, 2 }; // weights
     * int[] values = { 8, 4, 0, 5, 3 };
     * int capacity = 4;
     * System.out.println(Knapsack(weight, values, capacity, 0));
     * 
     * }
     * 
     * private static int Knapsack(int[] weight, int[] values, int capacity, int i)
     * {
     * if (i >= weight.length) {
     * return 0;
     * }
     * 
     * if (capacity == 0) {
     * return 0;
     * }
     * 
     * int inc = 0, exc = 0;
     * if (capacity >= weight[i]) {
     * inc = values[i] + Knapsack(weight, values, capacity - weight[i], i + 1);
     * }
     * exc = Knapsack(weight, values, capacity, i + 1);
     * return Math.max(inc, exc);
     * }
     */




    /*
     * public static void main(String[] args) {
     * int[] weight = { 1, 2, 3, 2, 2 }; // weights
     * int[] values = { 8, 4, 0, 5, 3 };
     * int capacity = 4;
     * int[][] dp = new int[capacity + 1][weight.length + 1];
     * // for (int a[] : dp) {
     * // Arrays.fill(a, -1);
     * // }
     * // for (int i = 0; i < dp.length; i++) {
     * // dp[0][i] = 0;
     * // }
     * System.out.println(Knapsack(dp,weight, values, capacity, 0));
     * 
     * }
     * 
     * private static int Knapsack(int[][] dp ,int[] weight, int[] values, int
     * capacity, int i) {
     * if (i >= weight.length) {
     * return 0;
     * }
     * 
     * if (capacity == 0) {
     * return 0;
     * }
     * 
     * if (dp[capacity][i] != 0) {
     * return dp[capacity][i];
     * }
     * int inc = 0, exc = 0;
     * if (capacity >= weight[i]) {
     * inc = values[i] + Knapsack(dp, weight, values, capacity - weight[i], i + 1);
     * }
     * exc = Knapsack(dp, weight, values, capacity, i + 1);
     * return dp[capacity][i] = Math.max(inc, exc);
     * }
     */

     
    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 2, 2 }; // weights
        int[] values = { 8, 4, 0, 5, 3 };
        int capacity = 4;

        System.out.println(Knapsack(weight, values, capacity));

    }

    private static int Knapsack(int[] weight, int[] values, int capacity) {
        int[][] dp = new int[capacity + 1][weight.length + 1];
        for (int cap = 1; cap < dp.length; cap++) {
            int inc = 0, exc = 0;
            for (int i = 1; i < dp[0].length; i++) {
                if (cap >= weight[i - 1]) {
                    inc = values[i - 1] + dp[cap - weight[i - 1]][i - 1];
                }
                exc = dp[cap][i - 1];
                dp[cap][i] = Math.max(inc, exc);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}