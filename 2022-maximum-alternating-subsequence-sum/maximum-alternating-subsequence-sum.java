// class Solution {
//     int arr[];
//     public long maxAlternatingSum(int[] nums) {
//         arr = nums;
//         int dp[][] = new int[nums.length+1][2];
//         return solve(0, true);
//     }

//     public long solve(int idx, boolean flag) {
//         if(idx >= arr.length) return 0;
//         long skip = solve(idx+1, flag);
//         long val = arr[idx];
//         if(flag == false) {
//             val = -val;
//         }
//         long take = solve(idx+1, !flag) + val;

//         return Math.max(skip, take);
//     }
// }



class Solution {
    int arr[];
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        arr = nums;
        dp = new long[nums.length+1][2];
        for(long a[] : dp) {
            Arrays.fill(a, -1);
        }
        return solve(0, 0);  // 0 --> + even
    }

    public long solve(int idx, int flag) {
        if(idx >= arr.length) return 0;
        if(dp[idx][flag] != -1) return dp[idx][flag];
        long skip = solve(idx+1, flag);
        long val = arr[idx];

        if(flag == 1) {
            val = -val;
        }
        long take = solve(idx+1, flag == 1 ? 0 : 1) + val;

        return dp[idx][flag] = Math.max(skip, take);
    }
}