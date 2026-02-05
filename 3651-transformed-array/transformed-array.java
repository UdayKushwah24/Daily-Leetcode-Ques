class Solution {
   public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int num = -1 * nums[i];
                num = (i - (num % n) + n) % n;  
                ans[i] = nums[num];

            } else if (nums[i] > 0) {
                int num = nums[i];
                num = (i + num) % n;
                ans[i] = nums[num];

            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

}