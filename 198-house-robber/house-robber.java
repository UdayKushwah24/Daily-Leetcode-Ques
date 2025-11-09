class Solution {


    
    public static int rob(int [] dp,int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int rob = nums[i] + rob(dp,nums, i+2);
        int notrob = rob(dp,nums, i+1);
        return dp[i] = Math.max(rob, notrob);
    }
    public int rob(int[] arr) {
         int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return rob(dp,arr, 0);
    }
}