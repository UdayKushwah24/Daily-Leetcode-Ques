package DynamicProgramming;
 
import java.util.Arrays;

public class UniquePaths2_63 {
    public int CountPaths(int[][] obstacleGrid, int cr, int cc, int[][] dp) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (cr == obstacleGrid.length - 1 && cc == obstacleGrid[0].length - 1) {

            return 1;
        }
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        if (cr > obstacleGrid.length - 1 || cc > obstacleGrid[0].length - 1 || obstacleGrid[cr][cc] == 1) {
            return 0;
        }

        if (obstacleGrid[cr][cc] == 1)
            return 0;

        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int c1 = CountPaths(obstacleGrid, cr + 1, cc,dp);
        int c2 = CountPaths(obstacleGrid, cr, cc + 1,dp);
        return dp[cr][cc] = c1 + c2;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        return CountPaths(obstacleGrid, 0, 0, dp);
    }
}