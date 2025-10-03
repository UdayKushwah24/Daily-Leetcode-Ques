package InfinityChampionsProgram.Day6;

public class BuildArrayPermutation_1920 {
    public static int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
