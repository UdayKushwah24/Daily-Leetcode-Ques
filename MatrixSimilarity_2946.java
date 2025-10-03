package InfinityChampionsProgram.Day6;

public class MatrixSimilarity_2946 {
    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        for (int i = 0; i < k; i++) {
            CyclicShift(mat, ans);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != ans[i][j]) {
                    return false;
                }
            }
        }



        return true;

    }

    private static void CyclicShift(int[][] mat, int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            
            for (int j = 0; j < ans[0].length; j++) {
                if (i % 2 == 0) {
                    ans[i][j] = j < ans.length - 1 ? mat[i][j + 1] : mat[i][0];
                } else {
                    ans[i][j] = j ==  0 ? mat[i][mat[0].length-1] : mat[i][j-1] ;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 1, 2 }, { 5, 5, 5, 5 }, { 6, 3, 6, 3} };
        int k = 2;
        // int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int k = 4;

        System.out.println(areSimilar(mat, k));

    }
}


/*
 * 
 * 
 * class Solution {
 * public boolean areSimilar(int[][] mat, int k) {
 * int m = mat.length;
 * int n = mat[0].length;
 * 
 * // reduce extra rotations
 * k %= n;
 * 
 * int[][] shifted = new int[m][n];
 * 
 * for (int i = 0; i < m; i++) {
 * for (int j = 0; j < n; j++) {
 * if (i % 2 == 0) { // even row -> left shift
 * shifted[i][j] = mat[i][(j + k) % n];
 * } else { // odd row -> right shift
 * shifted[i][j] = mat[i][(j - k + n) % n];
 * }
 * }
 * }
 * 
 * // check equality
 * for (int i = 0; i < m; i++) {
 * for (int j = 0; j < n; j++) {
 * if (mat[i][j] != shifted[i][j]) {
 * return false;
 * }
 * }
 * }
 * return true;
 * }
 * }
 */