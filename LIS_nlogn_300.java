package DynamicProgramming;

public class LIS_nlogn_300 {
    public static void main(String[] args) {
        int[] nums = {0, 8, 4, 2, 12, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println(lengthofLIS(nums));
    }

    private static int lengthofLIS(int[] nums) {
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

    private static int BinarySearch(int[] dp, int si, int ei, int k) {
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
