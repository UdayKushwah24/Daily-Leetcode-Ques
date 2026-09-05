/* class Solution {
     public static boolean isItSafe(char[][] grid, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == val) {
                return false;
            }
        }

        row = row - row % 3;
        col = col - col % 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {

                if (grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

     

    static boolean Solved = false;
    public static void Suduko(char[][] grid, int row, int col) {

        if (col == 9) {
            col = 0;
            row++;
        }
         
        if (row == 9) {
            Solved = true;
            return;
        }

        if (grid[row][col] != '.') {
            Suduko(grid, row, col + 1);
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isItSafe(grid, row, col,(char)(val+'0'))) {
                    grid[row][col] = (char)(val+'0');
                    Suduko(grid, row, col + 1);
                    if(Solved) {
                        return;
                    }
                    grid[row][col] = '.';
                }
            }
        }
    }
    public boolean isValidSudoku(char[][] board) {
        Suduko(board, 0, 0);
        return Solved;
    }
} */



class Solution {
    public static boolean isItSafe(char[][] grid, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == val || grid[row][i] == val) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    board[i][j] = '.';  // Temporarily remove the number to check validity

                    if (!isItSafe(board, i, j, num)) {
                        return false;
                    }
                    
                    board[i][j] = num;  // Restore the number after checking
                }
            }
        }
        return true;
    }
}
