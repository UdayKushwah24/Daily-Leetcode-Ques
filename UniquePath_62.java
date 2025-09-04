package DynamicProgramming;

import java.util.Arrays;

public class UniquePath_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int []i: dp) {
            Arrays.fill(i, -1);
        }
        return UniquePaths(m - 1, n - 1, 0, 0, dp);
    }

    public static int UniquePaths(int m, int n, int hor, int ver, int [][] dp) {
        if (m == hor && n == ver) {
            // System.out.println(ans);

            return 1;
        }
        if (hor > m || ver > n) {
            return 0;
        }
        if (dp[hor][ver] != -1) {
            return dp[hor][ver];
        }
        int n1 = UniquePaths(m, n, hor + 1, ver, dp);
        int n2 = UniquePaths(m, n, hor, ver + 1, dp);
        return dp[hor][ver] = n1 + n2;
    }
}
