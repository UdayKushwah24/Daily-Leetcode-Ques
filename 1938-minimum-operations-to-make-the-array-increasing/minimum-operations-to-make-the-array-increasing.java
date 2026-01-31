class Solution {
    public int minOperations(int[] nums) {
        int prev = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            int cc = nums[i];

            if (cc <= prev) {
                ans += (prev - cc + 1);
                prev = prev + 1;
            } else {
                prev = cc;
            }
        }
        return ans;
    }
}
