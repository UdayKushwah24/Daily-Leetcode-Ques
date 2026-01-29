class Solution {
    public int minOperations(int[] nums) {
        int flip = 0;
        int i = 0;
        int n = nums.length;
        for(int j = 0; j < n ;  j++) {
            if(nums[j] == 1) continue;
            if(j + 3 > n) return -1;
            for(int k = j; k < Math.min(n, j+3) ; k++) {
                if(nums[k] == 1) nums[k] = 0;
                else nums[k] = 1;
            }
            flip++;
        }
        return flip;
    }
}