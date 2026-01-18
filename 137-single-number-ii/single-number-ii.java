class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int k = 0; k < 32; k++) {
            int countZeros = 0;
            int countOnes = 0;
            int mask = 1<<k;
            for(int i = 0; i < nums.length; i++) {
                if((nums[i] & mask) == 0) {
                    countZeros++;
                } else {
                    countOnes++;
                }
            }
            if(countOnes % 3 == 1) {
                result = (result | (mask));
            }
        }
        return result;
    }
}