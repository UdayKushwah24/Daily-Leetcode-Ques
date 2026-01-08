class Solution {
    /* public boolean exist(char[][] board, String word) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean ans = SearchWord(board, word, i, j,0);
                    if(ans == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean SearchWord(char[][] board, String word, int cr, int cc, int idx) {
        if(word.length() == idx) {
            return true;
        }
        if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || word.charAt(idx) != board[cr][cc]) {
            return false;
        }
        board[cr][cc] = '*';
        int[] row = {-1, 0, 1, 0};
        int[] col = { 0,-1, 0, 1};
        for (int i = 0; i < col.length; i++) {
            boolean ans = SearchWord(board, word, cr+row[i], cc+col[i],idx+1);
            if(ans == true) {
                return true;
            }
        }
        board[cr][cc] = word.charAt(idx);
        return false;
    }  */

    static boolean isExists = false;
    public static boolean Search(char[][] board, String word, int row, int col,int idx) {
        if(word.length() == idx) {
            // isExists = true;
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)) {
            return false;
        }

        int[] r = {-1,1,0,0};
        int[] c = {0,0,-1,1};
        board[row][col] = '*';
        for (int i = 0; i < c.length; i++) {
           boolean ans = Search(board, word, row+r[i], col+c[i], idx+1);
           if(ans) {

            return true;
           }
        }
        board[row][col] = word.charAt(idx);
            return false;
    }
    public boolean exist(char[][] board, String word) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean ans =  Search(board, word, i, j,0);
                    if(ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}