class Solution {
     public static int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1) && board[i][j] == 1) {
                    dfs(board, i, j);
                } else if ((j == 0 || j == n - 1) && board[i][j] == 1) {
                    dfs(board, i, j);
                }
            }
        }

          int count= 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    count++;
                }
                
            }
           
        }
        return count;
    }

    private static void dfs(int[][] board, int i, int j) {
        board[i][j] = 0;
        int row[] = {-1, 1, 0, 0};
        int col[] = {0, 0, 1, -1};
        for (int k = 0; k < col.length; k++) {
            int newRow = i + row[k];
            int newCol = j + col[k];
            if (newRow >= 0 && newCol >= 0 && newCol < board[0].length && newRow < board.length && board[newRow][newCol] == 1) {
                dfs(board, newRow, newCol);
            }
        }
    }
}