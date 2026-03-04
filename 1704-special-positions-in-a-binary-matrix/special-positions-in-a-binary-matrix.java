class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        for (int i = 0; i < row.length; i++) {
            int c = 0;
            for (int j = 0; j < col.length; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }
            row[i] = c;
        }
        for (int j = 0; j < col.length; j++) {
            int c = 0;
            for (int i = 0; i < row.length; i++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }
            col[j] = c;
        }

      
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}