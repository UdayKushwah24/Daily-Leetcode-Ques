package InfinityChampionsProgram.Day6;

public class SumSubArrayMin_907 {

    public static int sumSubarrayMins(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
             
            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[j], min);
                 
                ans += min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins(arr));
    }
}