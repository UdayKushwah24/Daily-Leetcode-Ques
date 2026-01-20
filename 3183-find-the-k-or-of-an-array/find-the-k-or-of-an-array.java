class Solution {

    
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int set = 0;
            for(int j = 0; j  < nums.length; j++) {
                if((nums[j] & (1<<i)) != 0) {
                    set++;
                }
            }
            if(set >= k) {
                ans = ans | (1<<i);
            }
        }
        return ans;
    }
}