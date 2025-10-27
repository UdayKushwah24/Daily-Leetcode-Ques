class Solution {
    public int dominantIndex(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                } else {
                    if(nums[i] < 2 * nums[j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                return i;
            }

        }
        return -1;
    }
}