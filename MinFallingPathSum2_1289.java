package DynamicProgramming;

import java.util.*;

public class MinFallingPathSum2_1289 {
    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int a[] : dp) {
            Arrays.fill(a, -66666);
        }
        for (int col = 0; col < matrix[0].length; col++) {
            ans = Math.min(ans, PathSum(matrix, 0, col, dp));
        }
        return ans;
    }

    private static int PathSum(int[][] matrix, int cr, int cc, int[][] dp) {
        
        if (cr == matrix.length - 1) {
            return matrix[cr][cc];
        }

        if (dp[cr][cc] != -66666) {
            return dp[cr][cc];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (i == cc) {
                continue;
            }
           ans = PathSum(matrix, cr + 1, cc - 1, dp);
            
        }
        
        return dp[cr][cc] = ans;
    }
}
