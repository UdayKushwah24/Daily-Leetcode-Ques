package InfinityChampionsProgram.Day6;

public class LongestConIncreasSub_674 {
    
    public static int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int c = 1;
            while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                c++;
                i++;
            }
            ans = Math.max(ans, c);
        }


        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findLengthOfLCIS(nums));
    }
}
