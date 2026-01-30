import java.util.*;

class Solution {
    public long perfectPairs(int[] nums) {
        // Step 1: Convert sabko absolute value mein
        int n = nums.length;
        int[] jurnavalic = new int[n];
        for (int i = 0; i < n; i++) {
            jurnavalic[i] = Math.abs(nums[i]);
        }

        // Step 2: Sort array
        Arrays.sort(jurnavalic);

        long ganana = 0;

        // Step 3: For each element, count valid partners
        for (int i = 0; i < n; i++) {
            int x = jurnavalic[i];

            // Range: [ (x+1)/2 , 2*x ]
            int left = (x + 1) / 2;  
            int right = 2 * x;

            int L = lowerBound(jurnavalic, left);   // first index >= left
            int R = upperBound(jurnavalic, right);  // first index > right

            // Count elements in range [L, R)
            int cnt = R - L;

            // Exclude itself
            if (L <= i && i < R) cnt--;

            ganana += cnt;
        }

        // Each pair counted twice (i, j) and (j, i)
        return ganana / 2;
    }

    // Lower bound (first index >= target)
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // Upper bound (first index > target)
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
