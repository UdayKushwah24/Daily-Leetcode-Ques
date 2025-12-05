class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = nums[0];
        for(int i = 1 ; i < n ; i++) {
            pre[i] = pre[i-1] + nums[i];
        }

        int suf[] = new int[n];
        suf[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0; i--) {
            suf[i] = nums[i] + suf[i+1];
        }

        int ans = 0;
        for(int i = 0; i < n-1 ; i++) {             // ⬅ change 1
            int left = pre[i];
            int right = suf[i+1];                  // ⬅ change 2
            if((left - right) % 2 == 0) ans++;     // ⬅ change 3
        }
        return ans;
    }
}
