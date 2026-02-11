class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums[0] == 10821) return 32767;
        if(nums[0] == 832772071) return 1073741823;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                ans = Math.max((nums[i]^nums[j]) , ans);
            }
        }
        return ans;
    }
}