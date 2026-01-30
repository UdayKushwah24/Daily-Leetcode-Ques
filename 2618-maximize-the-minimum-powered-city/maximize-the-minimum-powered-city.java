class Solution {
    public long maxPower(int[] nums, int r, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            prefix[left] += nums[i];
            if (right + 1 < n) {
                prefix[right + 1] -= nums[i];
            }
        }

        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }

        long maxp = k;
        for (int num : nums)
            maxp += num;

        long left = 0;
        long right = maxp;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(prefix, mid, k, r)) {
                ans = mid; // mid is valid
                left = mid + 1; // try bigger
            } else {
                right = mid - 1;
            }
        }

        return ans;

    }

    public boolean isPossible(long[] prefix, long power, long k, int r) {
        int n = prefix.length;
        long[] diff = new long[n + 1];
        for (int i = 0; i < n - 1; i++) {
            if (i > 0)
                diff[i] += diff[i - 1];

            long current = prefix[i] + diff[i];
            long need = Math.max(0, power - current);
            if (need == 0)
                continue;
            if (need > k)
                return false;

            k -= need;
            diff[i] += need;
            int end = Math.min(n - 1, i + 2 * r + 1);
            diff[end] -= need;
        }
        return true;
    }
}