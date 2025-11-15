class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = nums[0]*nums[0];
        for(int i =1;i< nums.length;i++) {
            if(nums.length%(i+1)==0) {
                sum += nums[i]*nums[i];
            }
        }
        return sum;
    }
}