class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // reduce extra rotations
        k %= n;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) { // even row -> left shift
                    shifted[i][j] = mat[i][(j + k) % n];
                } else { // odd row -> right shift
                    shifted[i][j] = mat[i][(j - k + n) % n];
                }
            }
        }

        // check equality
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != shifted[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}