package DailyLeetcodeQuestion;

public class q8_MinOperation_by_K_3512 {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum % k;
    }
}