package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbingStairs(n, 0, dp);
    }

    public static int climbingStairs(int n, int chadGaya, int dp[]) {
        if (n == chadGaya) {
            return 1;
        }
        if (chadGaya > n) {
            return 0;
        }
        if (dp[chadGaya] != -1) {
            return dp[chadGaya];
        }
        int count1 = climbingStairs(n, chadGaya + 1 , dp);
        int count2 = climbingStairs(n, chadGaya + 2, dp);
        return dp[chadGaya ] =count1 + count2;
    }
}
