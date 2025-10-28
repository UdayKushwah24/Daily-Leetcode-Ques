package DynamicProgramming;

import java.util.Arrays;

public class RussianDoll {
     public static int maxEnvelopes(int[][] envelopes) {
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

    
    private static  int lengthofLIS(int[] nums) {
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

    private static  int BinarySearch(int[] dp, int si, int ei, int k) {
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
}
