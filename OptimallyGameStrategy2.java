package DynamicProgramming;

import java.util.*;
public class OptimallyGameStrategy2 {
  /*   public static void main(String[] args) {
    int[] arr = { 3, 1, 3, 5, 7 };
    int dp[][] = new int[arr.length][arr.length];
    System.out.println(OptimalGame(dp,arr, 0, arr.length-1));
  }
  
  private static int OptimalGame ( int[][] dp, int[] arr, int i, int j) {
    if (i > j) {
        return 0;
    }
  
    int f = arr[i] + Math.min(OptimalGame(dp,arr, i + 2, j), OptimalGame(dp,arr, i + 1, j - 1));        
    int s = arr[j] + Math.min(OptimalGame(dp,arr, i + 1, j - 1), OptimalGame(dp,arr, i, j - 2));
    return dp[i][j] = Math.max(f, s);   
  } */
   
  public static void main(String[] args) {
      int[] arr = { 3, 1, 3, 5, 7 };
      int dp[][] = new int[arr.length][arr.length];
      for (int a[] : dp) {
          Arrays.fill(a, -1);
      }
      System.out.println(OptimalGame(dp, arr, 0, arr.length - 1));
  }

  private static int OptimalGame(int[][] dp, int[] arr, int i, int j) {
      if (i > j) {
          return 0;
      }
      if (dp[i][j] != -1) {
          return dp[i][j];
      }

      int f = arr[i] + Math.min(OptimalGame(dp, arr, i + 2, j), OptimalGame(dp, arr, i + 1, j - 1));
      int s = arr[j] + Math.min(OptimalGame(dp, arr, i + 1, j - 1), OptimalGame(dp, arr, i, j - 2));
      return dp[i][j] = Math.max(f, s);
  }
}
