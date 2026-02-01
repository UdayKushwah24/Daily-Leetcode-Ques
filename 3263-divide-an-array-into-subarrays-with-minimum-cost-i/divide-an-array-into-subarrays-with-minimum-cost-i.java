class Solution {
    public int minimumCost(int[] nums) {
        int f_min = Integer.MAX_VALUE;
        int s_min = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < f_min) {
                s_min = f_min;
                f_min = nums[i];
            } else if (nums[i] < s_min) {
                s_min = nums[i];
            }
        }

        return nums[0] + f_min + s_min;
    }
}