/* class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < 2; i++) {
            if(nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-3]*nums[n-2]*nums[n-1]);
    }
} */



import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums); // Sort array
        int n = nums.length;
        
        int prod1 = nums[n-1] * nums[n-2] * nums[n-3]; // 3 largest
        int prod2 = nums[0] * nums[1] * nums[n-1];     // 2 smallest + largest
        
        return Math.max(prod1, prod2);
    }
}
