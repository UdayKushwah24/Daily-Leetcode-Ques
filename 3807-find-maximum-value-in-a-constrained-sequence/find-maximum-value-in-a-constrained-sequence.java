class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {

        long[] ans = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE/2);

        ans[0] = 0;
        // Apply direct restrictions
        for (int i = 0; i < restrictions.length; i++) {
            int idx = restrictions[i][0];
            int limit = restrictions[i][1];
            ans[idx] = Math.min(ans[idx], limit);
        }

        // Forward pass
        for (int i = 0; i < n - 1; i++) {
            ans[i + 1] = Math.min(ans[i + 1], ans[i] + diff[i]);
        }

        // Backward pass
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.min(ans[i], ans[i + 1] + diff[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i  < n ; i++) {
            max = Math.max(max, (int)ans[i]);
        }
        return max;
    }
}
