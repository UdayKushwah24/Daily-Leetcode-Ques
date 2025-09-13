package DynamicProgramming;

public class MinFallPathSum_931 {

    public static int Falling_Path_sum(int[][] matrix, int cr, int cc) {

        if (cc < 0 || cc >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (cr == matrix.length - 1) {
            return matrix[cr][cc];
        }
        int dl = Falling_Path_sum(matrix, cr + 1, cc - 1);
        int dr = Falling_Path_sum(matrix, cr + 1, cc + 1);
        int db = Falling_Path_sum(matrix, cr + 1, cc);
        return Math.min(dr, Math.min(dl, db)) + matrix[cr][cc];
    }

    public static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            ans = Math.min(ans, Falling_Path_sum(matrix, 0, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));

    }

}
