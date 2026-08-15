class Solution {
    public int longestSubsequence(int[] nums) {
        int total = 0;
        int len = nums.length;

        boolean nonZero = false;

        for (int num : nums) {
            if (num != 0) {
                nonZero = true;
            }
            total ^= num;
        }

        if (total != 0) {
            return len;
        }

        if (nonZero) {
            return len - 1;
        }

        return 0;
    }
}