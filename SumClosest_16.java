package InfinityChampionsProgram.Day1;

import java.util.*;

public class SumClosest_16 {
    public static void main(String[] args) {
        // int[] nums = {-1,2,1,-4};
        // int target = 1;

        int[] nums = { 1,1,1,0 };
        int target = -100;
        // int[] nums = { 0,0,0,0 };
        // int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
    
    public static int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += nums[i];
        }
        ans = sum;
        int diff = Integer.MAX_VALUE;

        int a = sum; 
        int d = Integer.MIN_VALUE;
        for (int i = 3; i < nums.length; i++) {
            if (Math.abs((sum - target)) < diff) {
                ans = sum;
                diff = Math.abs(sum - target);
            }
            if (Math.abs(sum - target) > d) {
                a = sum;
                d = Math.abs(sum - target);
            }
            sum += nums[i];
            // ans = Math.min(ans, sum);
            sum -= nums[i - 3];
        }
        System.out.println(ans);
        System.out.println(a);
        return Math.min(a, ans);
    }
}
