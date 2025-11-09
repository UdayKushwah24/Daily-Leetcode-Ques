class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] == b[0]) {
                return b[1]-a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int h[] = new int[envelopes.length];
        for(int i = 0; i < h.length;i++) {
            h[i] = envelopes[i][1];
        }
        return lengthofLIS(h);
    }

    
    private   int lengthofLIS(int[] nums) {
        int [] dp = new int[nums.length];
        
        int len = 1;
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                int idx = BinarySearch(dp, 0, len - 1, nums[i]);
                dp[idx] = nums[i];
            }
        }
        return len;
    }

    private   int BinarySearch(int[] dp, int si, int ei, int k) {
        int idx = 0;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (dp[mid] >= k) {
                idx = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return idx;
    }




    // O(n^2)
    // public int LIS(int[] h) {
    //     int n = h.length;
    //     int[] dp =  new int[n];
    //     Arrays.fill(dp, 1);
    //     for(int i = 1; i < n ; i++) {
    //         for(int j = i-1; j >= 0;  j--) {
    //             if(h[i] > h[j]) {
    //                 int m = dp[j];
    //                 dp[i] = Math.max(m+1, dp[i]);
    //             }
    //         }
    //     }
    //     int max = 0;
    //     for(int i = 0; i < dp.length; i++) {
    //         max = Math.max(dp[i], max);
    //     }
    //     return max;
    // }
}