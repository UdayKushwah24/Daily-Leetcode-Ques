class Solution {
    int mod = 1000000007;
    int m;
    int n;

    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int dp[][][] = new int[m][n][k];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(dp, grid, 0, 0, 0, k);
    }

    public int solve(int[][][] dp, int[][] grid, int i, int j, int sum, int k) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            sum += grid[i][j];
            return (sum % k == 0) ? 1 : 0;
        }
        if (dp[i][j][sum] != -1) {
            return dp[i][j][sum];
        }

        int l = solve(dp, grid, i + 1, j, (sum + grid[i][j]) % k, k);
        int r = solve(dp, grid, i, j + 1, (sum + grid[i][j]) % k, k);
        return dp[i][j][sum] = (l + r) % mod;
    }
}