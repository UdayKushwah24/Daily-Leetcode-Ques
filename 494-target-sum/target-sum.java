class Solution {

      int count = 0;

    public   int findTargetSumWays(int[] nums, int target) {

        solve(nums, target, 0, 0);
        return count;
    }

    private   void solve(int[] nums, int target, int sum, int i) {

        if (i == nums.length) {
            if (sum == target) {
                count += 1;
            }
            return;
        }

        solve(nums, target, sum + nums[i], i + 1);
        solve(nums, target, sum - nums[i], i + 1);

    }
}