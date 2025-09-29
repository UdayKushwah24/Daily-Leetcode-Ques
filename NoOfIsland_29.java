package InfinityChampionsProgram.Day3;

public class NoOfIsland_29 {

    

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '*') {
            return;
        }

        grid[i][j] = '*'; // mark visited
        dfs(grid, i, j - 1); // left
        dfs(grid, i - 1, j); // top
        dfs(grid, i, j + 1); // right
        dfs(grid, i + 1, j); // bottom
    }

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0',
                '0' }, { '0', '0', '0', '1', '1' } };
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    island++;
                }
            }
        }
        System.out.println(island);
    }
}
