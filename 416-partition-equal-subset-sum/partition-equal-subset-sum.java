class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        int targetSum = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][targetSum+1];
        return solve(dp, nums, n - 1, targetSum);
    }

    public boolean solve( Boolean[][] dp, int[] nums, int i, int targetSum) {
        if(i < 0) return false;
        if (targetSum == 0) {
            return dp[i][targetSum] = true;
        }
        if (i == 0 ) {
            return targetSum == nums[0];
        }

        if(i >= 0 && dp[i][targetSum] != null) return dp[i][targetSum] ;
        boolean notPick = solve(dp, nums, i - 1, targetSum);
        boolean pick = false;
        if (nums[i] <= targetSum) {
            pick = solve(dp, nums, i - 1, targetSum - nums[i]);
        }
        
       
        return  dp[i][targetSum] = pick || notPick;
    }

}
