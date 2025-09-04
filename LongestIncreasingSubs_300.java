package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubs_300 {

     // TC : O(n^2)
  public static int lengthofLIS(int[] nums) {
    int[] lis = new int[nums.length];
    Arrays.fill(lis, 1);
    for (int i = 1; i < lis.length; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                int l = lis[j];
                lis[i] = Math.max(lis[i], l + 1);
            }
        }
    }
    int max = lis[0];
    for (int i = 0; i < lis.length; i++) {
        max = Math.max(max, lis[i]);
    }
    return max;
  } 
   
 
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthofLIS(nums));
    }
}
