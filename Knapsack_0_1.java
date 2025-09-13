package DynamicProgramming;

import java.util.Scanner;

public class Knapsack_0_1 {
   /*  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      int[] weight = new int[n];
      for (int i = 0; i < weight.length; i++) {
          weight[i] = sc.nextInt();
      }
   
      int[] value = new int[n];
      for (int i = 0; i < value.length; i++) {
          value[i] = sc.nextInt();
      }
   
      int capacity = sc.nextInt();
   
      System.out.println(Knapsack(weight, value,capacity,0));
   } */
   
   
   /* public static void main(String[] args) {
     int[] weight = { 1, 2, 3, 2, 2 };
     int[] value = { 8, 4, 0, 5, 3 };
     int cap = 4;
   
     System.out.println(Knapsack(weight, value, cap, 0));
   }
   
   public static int Knapsack(int[] weight, int[] value, int cap, int i) {
      if (cap == 0 || i == weight.length) {
          return 0;
      }
      int inc = 0, exc = 0;
      if (cap >= weight[i]) {
          inc = weight[i] + Knapsack(weight, value, cap - weight[i], i + 1);
      }
      exc = Knapsack(weight, value, cap, i + 1);
      return Math.max(inc, exc);
   } */
   
   
    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 2, 2 };
        int[] value = { 8, 4, 0, 5, 3 };
        int cap = 4;
        int dp[] = 
        System.out.println(Knapsack(weight, value, cap, 0));
    }

    public static int Knapsack(int[] weight, int[] value, int cap, int i) {
        if (cap == 0 || i == weight.length) {
            return 0;
        }
        int inc = 0, exc = 0;
        if (cap >= weight[i]) {
            inc = weight[i] + Knapsack(weight, value, cap - weight[i], i + 1);
        }
        exc = Knapsack(weight, value, cap, i + 1);
        return Math.max(inc, exc);
    }
}
