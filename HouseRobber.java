package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    // TC : O(n)
    public static int Robber(int[] dp, int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int rob = nums[i] + Robber(dp, nums, i + 2);
        int not_rob = Robber(dp, nums, i + 1);
        return dp[i] = Math.max(rob, not_rob);
    }
    // TC : O(n)
    public static int Robber2(int[] dp, int[] nums, int l) {
        if (l < 0) {
            return 0;
        }
        if (dp[l] != -1) {
            return dp[l];
        }
        int rob = nums[l] + Robber2(dp, nums, l - 2);
        int not_rob = Robber2(dp, nums, l - 1);
        return dp[l] = Math.max(rob, not_rob);
    }
    
    // TC : O(n)
    public static int RobberBU(int[] nums) {
        if (nums.length == 1)  {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < dp.length; i++) {
            int rob = nums[i] + dp[i - 2];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        // System.out.println(Robber(dp, nums, 0));
        // System.out.println(Robber2(dp, nums,nums.length-1));
        System.out.println(RobberBU(nums));
    }
}
