package DynamicProgramming;

import java.util.Arrays;

public class MCM {
    /* public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 5, 1 };
        System.out.println(mcm(arr, 0, arr.length-1));
        
    }
    
    private static int mcm(int[] arr, int i, int j) {
    
        if (i+1 == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int fs = mcm(arr, i, k); // i x k
            int ss = mcm(arr, k, j); // k x j
            int self = arr[i] * arr[k] * arr[j]; // [i x k]*[k x j]
            ans = Math.min(ans, fs + ss + self);
    
        }
        return ans;
    } */
   


    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 5, 1 };
        int dp[][] = new int[arr.length][arr.length];
         
        System.out.println(mcm(dp,arr, 0, arr.length - 1));

    }

    private static int mcm(int dp[][] ,int[] arr, int i, int j) {

        if (i + 1 == j) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int fs = mcm(dp,arr, i, k); // i x k
            int ss = mcm(dp,arr, k, j); // k x j
            int self = arr[i] * arr[k] * arr[j]; // [i x k]*[k x j]
            ans = Math.min(ans, fs + ss + self);

        }
        return dp[i][j] = ans;
    }
}
