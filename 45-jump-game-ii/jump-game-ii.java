/* class Solution {
    public int jump(int[] nums) {
        return solve(nums, 0, 0);
    }

    public int solve(int nums[], int idx, int jumps) {
        if(idx >= nums.length) return 0;
        if(idx == nums.length-1) return jumps;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= nums[idx]; i++) {
            if(idx + i < nums.length)
            min = Math.min(min, solve(nums, idx+i, jumps+1));
        }
        return min;
    }
}
 */
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}

 