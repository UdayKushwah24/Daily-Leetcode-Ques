package DynamicProgramming;

import java.util.Arrays;

public class EditDistance_72 {
    public static int minOperation(String s, String t, int i, int j, int[][] dp) {
        if (i == s.length()) {
            return t.length() - j;
        }
        if (j == t.length()) {
            return s.length() - i;
        }
        int ans = 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + minOperation(s, t, i + 1, j + 1, dp);
        } else {
            int delete = minOperation(s, t, i + 1, j,dp);
            int remove = minOperation(s, t, i + 1, j + 1,dp);
            int insert = minOperation(s, t, i, j + 1, dp);
            ans = Math.min(delete, Math.min(remove, insert) + 1);
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        String s = "intention", t = "execution";
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(minOperation(s, t, 0, 0, dp));
    }
}