package InfinityChampionsProgram.Day3;

public class CountIsland_3619 {

    static int sum = 0;

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        if (grid[i][j] == -1) {
            return;
        }
        sum += grid[i][j];

        grid[i][j] = -1; // mark visited
        dfs(grid, i, j - 1); // left
        dfs(grid, i - 1, j); // top
        dfs(grid, i, j + 1); // right
        dfs(grid, i + 1, j); // bottom
    }

    public static int countIslands(int[][] grid, int k) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j);
                     
                    if (sum != 0 && sum % k == 0)
                        count += 1;
                    sum = 0;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2, 1, 0,0 },
                { 0, 5, 0, 0, 5 },
                { 0, 0, 1, 0,0 },
                { 0, 1, 4, 7, 0 },
                { 0, 2, 0, 0, 8 } };
        int k = 5;
        System.out.println(countIslands(grid, k));

    }

}
