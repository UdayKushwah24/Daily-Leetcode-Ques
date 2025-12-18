class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0;
        int max = 0;
        for(int i = 0; i < k; i++) {
            min += nums[i];
        }
        for(int i = nums.length-1; i >= nums.length - k; i--) {
            max += nums[i];
        }


        return max - min;
    }
}