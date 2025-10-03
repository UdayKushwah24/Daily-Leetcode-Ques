package InfinityChampionsProgram.Day6;

public class SumOfSubarrayRange_2104 {
    public static long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                ans += max - min;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subArrayRanges(nums));
    }
}
