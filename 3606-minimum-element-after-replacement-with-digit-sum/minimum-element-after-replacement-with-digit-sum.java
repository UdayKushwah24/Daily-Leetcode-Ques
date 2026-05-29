class Solution {
    public static int Sum_Digit(int n) {
        int sum = 0;
        while(n > 0) {
            int last_digit = n%10;
            sum+=last_digit;
            n /= 10;
        }
        return sum;
    }

    public static int Min_ele(int[] arr ){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public int minElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Sum_Digit(nums[i]);
        }
        return Min_ele(nums);
    }
}