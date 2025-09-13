package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum_64 {
    /*
     * public static int minPathSum(int[][] grid) {
     * 
     * return PathSum(grid, 0, 0);
     * }
     * 
     * private static int PathSum(int[][] arr, int r, int c) {
     * if (r == arr.length - 1 && c == arr[0].length - 1) {
     * return arr[r][c];
     * }
     * if (r >= arr.length || c >= arr[0].length) {
     * return Integer.MAX_VALUE;
     * }
     * int right = PathSum(arr, r, c + 1);
     * int down = PathSum(arr, r + 1, c);
     * return Math.min(right, down) + arr[r][c];
     * }
     * 
     * public static void main(String[] args) {
     * int[][] arr = { { 1, 3, 1 },
     * { 1, 5, 1 },
     * { 4, 2, 1 } };
     * System.out.println(minPathSum(arr));
     * }
     */



  
    private static int minPathSum(  int dp[][],int[][] arr, int r, int c) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            return arr[r][c];
        }
        if (r >= arr.length || c >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int right = minPathSum(dp,arr, r, c + 1);
        int down = minPathSum(dp,arr, r + 1, c);
        return dp[r][c] = Math.min(right, down) + arr[r][c];
    }




    private static int PathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                dp[i][j] = arr[i][j] + Math.min(left, top);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 } };
        System.out.println(PathSum(arr));
        int dp[][] = new int[arr.length][arr[0].length];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(minPathSum(dp,arr,0,0));
    }
}
