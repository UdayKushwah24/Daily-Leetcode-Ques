 
class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n-1 && nums[i+1] > nums[i]) {
            i++;
        }
        if(i == 0 || i == n-1) return false;
        while(i < n-1 && nums[i+1] < nums[i]) {
            i++;
        }
        if( i == n-1) return false;
        while(i < n-1 && nums[i+1] > nums[i]) {
            i++;
        }
        if( i == n-1) return true;

        return false;

    }
}