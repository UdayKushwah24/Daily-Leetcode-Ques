class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length;i++) {
            int x = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                int y = nums[j];
                if(Math.abs(x-y) <= Math.min(x, y)){
                    ans = Math.max(x^y, ans);
                }
            }
        }
        return ans;
    }
}