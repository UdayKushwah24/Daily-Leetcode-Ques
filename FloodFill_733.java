package InfinityChampionsProgram.Day3;

public class FloodFill_733 {

    private static void dfs(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        if (grid[i][j] == color) {
            return;
        }
        

        grid[i][j] = color; // mark visited
        
        dfs(grid, i, j - 1, color); // left
        dfs(grid, i - 1, j, color); // top
        dfs(grid, i, j + 1, color); // right
        dfs(grid, i + 1, j, color); // bottom
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
            dfs(image, sr, sc, color);
            return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int ans[][] = floodFill(image, sr, sc, color);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
