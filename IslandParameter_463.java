package InfinityChampionsProgram.Day3;

public class IslandParameter_463 {

    static int perimeter = 0;

    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return -1;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            perimeter++;
            return;
        }

        if (grid[i][j] == -1) {
            return;
        }

        grid[i][j] = -1; // mark visited
        dfs(grid, i, j - 1); // left
        dfs(grid, i - 1, j); // top
        dfs(grid, i, j + 1); // right
        dfs(grid, i + 1, j); // bottom
    }

    public static void SimpleTraversal(int[][] grid) {
        int peri = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (j == 0 || grid[i][j - 1] == 0)
                        peri++; // left
                    if (i == 0 || grid[i - 1][j] == 0)
                        peri++; // top
                    if (j == n - 1 || grid[i][j + 1] == 0)
                        peri++; // right
                    if (i == m - 1 || grid[i + 1][j] == 0)
                        peri++; // bottom
                }
            }
        }
        System.out.println(peri);
    }


    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(islandPerimeter(grid));
        SimpleTraversal(grid);
    }
}
