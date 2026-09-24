class Solution {
    
    public int sum(int n) {
        int s = 0;
        while(n != 0) {
            int r = n % 10;
            s += r;
            n /= 10;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            if(i == sum(nums[i])) {
                return i;
            }
        }
        return -1;
    }
    
}