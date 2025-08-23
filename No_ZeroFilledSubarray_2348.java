package Heap;
 
public class No_ZeroFilledSubarray_2348 {
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {

                ans += (count * (count + 1)) / 2;
                count = 0;
            }

        }

        ans += (count * (count + 1)) / 2;
        return ans;
    }

    // public static long zeroFilledSubarray(int[] nums) {

    //     long ans = 0;

    //     for (int i = 0; i < nums.length; i++) {
    //         int count = 0;
    //         while (i < nums.length && nums[i] == 0) {
    //             count++;
    //             i++;
    //             ans += count;
    //         }

    //     }

    //     return ans;
    // }

    public static void main(String[] args) {
        int nums[] = { 0, 0, 0, 2, 0, 0 };
        // int nums[] = { 1, 3, 0, 0, 2, 0, 0, 4 };
        // System.out.println("ans");
        System.out.println(zeroFilledSubarray(nums));
    }
}