/* class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n - 1];
        Arrays.fill(dp1, -1);
        int nums1[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }

        int[] dp2 = new int[n - 1];
        Arrays.fill(dp2, -1);
        int nums2[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums2[i] = nums[i+1];
        }
        int removeLast = Robber(nums1, 0, dp1);
        int removeFirst = Robber(nums2, 0, dp2);
        return Math.max(removeLast, removeFirst);
    }

    public static int Robber(int[] nums, int i, int[] dp) {

        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        int rob = nums[i] + Robber(nums, i + 2, dp);

        int notRob = Robber(nums, i + 1, dp);

        return dp[i] = Math.max(rob, notRob);

    }
} */




class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n ];
        Arrays.fill(dp1, -1);
        

        int[] dp2 = new int[n ];
        Arrays.fill(dp2, -1);
       
        int removeLast = Robber(nums, 0, n-1, dp1);
        int removeFirst = Robber(nums, 1, n, dp2);
        return Math.max(removeLast, removeFirst);
    }

    public static int Robber(int[] nums, int i, int n, int[] dp) {

        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        int rob = nums[i] + Robber(nums, i + 2,n, dp);

        int notRob = Robber(nums, i + 1,n, dp);

        return dp[i] = Math.max(rob, notRob);

    }
}