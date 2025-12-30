class Solution {

    // Main function: counts number of 3x3 magic squares inside the grid
    public int numMagicSquaresInside(int[][] grid) {

        int m = grid.length;        // number of rows
        int n = grid[0].length;     // number of columns
        int count = 0;              // stores count of magic squares

        // Traverse each cell as a possible top-left corner of 3x3 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Check if the 3x3 subgrid starting at (i, j) is magic
                if (isMagicSquare(grid, i, j)) {
                    count++;        // increment count if magic square found
                }
            }
        }

        return count;               // return total number of magic squares
    }

    // Helper function to check whether a 3x3 grid is a magic square
    public static boolean isMagicSquare(int[][] grid, int r, int c) {

        // Boundary check: ensure 3x3 grid fits inside the matrix
        if (r + 2 >= grid.length || c + 2 >= grid[0].length) {
            return false;
        }

        // In a 3x3 magic square using numbers 1–9, center must be 5
        if (grid[r + 1][c + 1] != 5) {
            return false;
        }

        // Array to track whether numbers 1–9 are used exactly once
        boolean[] seen = new boolean[10];

        // Check all values in the 3x3 grid
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {

                int val = grid[i][j];   // current cell value

                // Value must be between 1 and 9 and unique
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }

                seen[val] = true;       // mark value as seen
            }
        }

        // Check sum of all rows
        for (int i = 0; i < 3; i++) {
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != 15) {
                return false;
            }
        }

        // Check sum of all columns
        for (int j = 0; j < 3; j++) {
            if (grid[r][c + j] + grid[r + 1][c + j] + grid[r + 2][c + j] != 15) {
                return false;
            }
        }

        // Check main diagonal sum
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != 15) {
            return false;
        }

        // Check secondary diagonal sum
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != 15) {
            return false;
        }

        // All conditions satisfied → magic square found
        return true;
    }
}
