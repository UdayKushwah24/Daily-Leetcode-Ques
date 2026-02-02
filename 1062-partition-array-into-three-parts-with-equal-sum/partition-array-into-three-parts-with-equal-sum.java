class Solution {
    public boolean canThreePartsEqualSum(int[] nums) {

        long sum = 0;
        for (int x : nums) sum += x;

        if (sum % 3 != 0) return false;

        long target = sum / 3;
        long ccSum = 0;
        int count = 0;

        // loop till n-1 to keep third part non-empty
        for (int i = 0; i < nums.length - 1; i++) {
            ccSum += nums[i];

            if (ccSum == target) {
                count++;
                ccSum = 0;   // reset for next part
            }

            if (count == 2) return true;
        }  
        return false;
    }
}
