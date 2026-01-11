/* class Solution {
    private static void dfs(int[][] grid, int i, int j, int original, int color) {
        // boundary check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        // agar different color hai ya already fill ho chuka hai toh return
        if (grid[i][j] != original || grid[i][j] == color) {
            return;
        }

        // fill karo
        grid[i][j] = color;

        // neighbours
        dfs(grid, i, j - 1, original, color); // left
        dfs(grid, i - 1, j, original, color); // top
        dfs(grid, i, j + 1, original, color); // right
        dfs(grid, i + 1, j, original, color); // bottom
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) { // warna infinite recursion ho jaayega
            dfs(image, sr, sc, original, color);
        }
        return image;
    }
} */



class Solution {

     private   void dfs(int[][] image, int originalColor,  int color, int sr, int sc) {
        image[sr][sc] = color;
        
        int row[] = {-1, 1, 0, 0};
        int col[] = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = sr + row[i];
            int newCol = sc + col[i];
            if(newRow >= 0 && newCol >= 0 && newCol < image[0].length && newRow < image.length && image[newRow][newCol] == originalColor ) {
                dfs(image, originalColor, color, newRow, newCol);
            }
        }

    }
 

    public   int[][] floodFill(int[][] image, int sr, int sc, int color) {
         
        int originalColor = image[sr][sc];
        if (originalColor != color) {
                        dfs(image, originalColor, color, sr, sc);
        }
        return image;
    }
}