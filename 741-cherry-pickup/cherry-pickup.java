/* class Solution {
   
      int cherries = 0;

    public   int cherryPickup(int[][] grid) {
        solve(grid, 0, 0, 0);
        return cherries;
    }

    private   void solve(int[][] grid, int row, int col, int ccsf) {

        if (row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
            return;
        }

        int cherry = grid[row][col];
        grid[row][col] = 0;

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            helper(grid, row, col, ccsf + cherry);
            grid[row][col] = cherry;
            return;
        }

        solve(grid, row + 1, col, ccsf + cherry);
        solve(grid, row, col + 1, ccsf + cherry);

        grid[row][col] = cherry;
    }

    private   void helper(int[][] grid, int row, int col, int ccsf) {

        if (row < 0 || col < 0 || grid[row][col] == -1) {
            return;
        }

        if (row == 0 && col == 0) {
            cherries = Math.max(cherries, ccsf);
            return;
        }

        int cherry = grid[row][col];
        grid[row][col] = 0;

        helper(grid, row - 1, col, ccsf + cherry);
        helper(grid, row, col - 1, ccsf + cherry);

        grid[row][col] = cherry;
    }

} */



class Solution {

    int n;
    int[][] grid;
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        dp = new Integer[n][n][n];
        return Math.max(0, solve(0, 0, 0));
    }

    // DP version of solve + helper combined
    private int solve(int r1, int c1, int r2) {

        int c2 = r1 + c1 - r2;

        // invalid state
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }



        // destination reached
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }



        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }

        int cherries = grid[r1][c1];



        // avoid double count
        if (r1 != r2) {
            cherries += grid[r2][c2];
        }



        int best = Math.max(
                Math.max(
                        solve(r1 + 1, c1, r2 + 1),
                        solve(r1, c1 + 1, r2)
                ),
                Math.max(
                        solve(r1 + 1, c1, r2),
                        solve(r1, c1 + 1, r2 + 1)
                )
        );

        cherries += best;
        dp[r1][c1][r2] = cherries;
        return cherries;
    }
}
