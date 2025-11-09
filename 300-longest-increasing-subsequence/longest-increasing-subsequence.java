class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1 ;i  < n;i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    int l = dp[j];
                    dp[i] = Math.max(dp[i], l+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}