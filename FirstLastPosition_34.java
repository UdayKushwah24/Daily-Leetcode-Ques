package InfinityChampionsProgram.Day1;

public class FirstLastPosition_34 {
    
    
        public static int[] searchRange(int[] nums, int target) {
            int[] ans = { -1, -1 };
            int idx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) {
                return ans;
            }
            ans[0] = idx;

            // Find the last occurrence
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    ans[1] = i; // set end index
                    break;
                }
            }
            return ans;
        }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
}
