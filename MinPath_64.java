package DynamicProgramming;

public class MinPath_64 {
    static int ans = Integer.MAX_VALUE;

    public void minPathSum(int[][] grid, int row, int col, int sum) {
        if (row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            sum += grid[grid.length - 1][grid[0].length - 1];
            ans = Math.min(ans, sum);
            // System.out.println(str);
            return;
        }
        // sum += grid[row][col];
        int m = minPathSum(grid, row + 1, col, sum + grid[row][col]);
        int n = minPathSum(grid, row, col + 1, sum + grid[row][col]);
        
    }

    public int minPathSum(int[][] grid) {
        ans = Integer.MAX_VALUE;
        minPathSum(grid, 0, 0, 0);
        return ans;
    }
}
