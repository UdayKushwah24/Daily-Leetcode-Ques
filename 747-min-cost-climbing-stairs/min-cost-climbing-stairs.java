class Solution {
    public   int ClimbingStairs(int[] cost, int i, int dp[]) {
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
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);
        int zeroth = ClimbingStairs(cost, 0, dp);
        int first = ClimbingStairs(cost, 1, dp);
          return Math.min(zeroth, first);
    }
}