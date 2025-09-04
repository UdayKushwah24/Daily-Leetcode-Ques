package DynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStairs_746 {

    public static int ClimbingStairs(int[] cost, int i, int dp[]) {
        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int step1 =   ClimbingStairs(cost, i + 1, dp);
        int step2 =   ClimbingStairs(cost, i + 2, dp);
        return dp[i] = Math.min(step1, step2) + cost[i];

    }

    public static void main(String[] args) {
        int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);
        int zeroth = ClimbingStairs(cost, 0, dp);
        int first = ClimbingStairs(cost, 1, dp);
        System.out.println(Math.min(zeroth, first));
    }
}
