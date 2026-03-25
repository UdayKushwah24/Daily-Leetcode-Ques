class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rs = new long[m];
        long[] cs = new long[n];

        long t = 0;

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            rs[i] = sum;
            t += sum;
        }
        for (int j = 0; j < n; j++) {
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }
            cs[j] = sum;
        }
        if (t % 2 != 0)
            return false;

        long tar = (t / 2);

        long curr = 0;
        for (int i = 0; i < m - 1; i++) {
            curr += rs[i];
            if (curr == tar)
                return true;
        }

        curr = 0;
        for (int j = 0; j < n - 1; j++) {
            curr += cs[j];
            if (curr == tar)
                return true;
        }

        return false;

    }
}