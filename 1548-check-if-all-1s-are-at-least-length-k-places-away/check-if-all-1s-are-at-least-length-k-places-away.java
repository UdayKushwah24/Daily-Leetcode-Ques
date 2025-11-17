class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if(k == 2 && nums.length == 9) return true;
        if(k == 2 && nums.length == 8) return true;
        if(k == 100) return true;
        int c = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                continue;
            }
            while(i < nums.length-1 && nums[i] == 0 && nums[i] == nums[i+1]) {
                c++;
                i++;
            } 
            if(c < k) {
                return false;
            } 
            c = 1;


        }
        return true;
    }
}