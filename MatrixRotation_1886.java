/* package InfinityChampionsProgram.Day6;

public class MatrixRotation_1886 {
    public boolean checking(int[][] target, int[][] arr) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (target[i][j] != arr[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;

        // Check 0° rotation
        if (checking(target, mat))
            return true;

        int[][] res = new int[n][m];
        int[][] res1 = new int[n][m];
        int[][] res2 = new int[n][m];

        // 90° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[m - 1 - j][i] = mat[i][j];
            }
        }

        // 180° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res1[m - 1 - j][i] = res[i][j];
            }
        }

        // 270° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res2[m - 1 - j][i] = res1[i][j];
            }
        }

        // Compare rotations
        if (checking(target, res))
            return true;
        if (checking(target, res1))
            return true;
        if (checking(target, res2))
            return true;

        return false;
    }
    public static void main(String[] args) {
        
    }
}
 */

 package InfinityChampionsProgram.Day6;

public class MatrixRotation_1886 {
    public boolean checking(int[][] target, int[][] arr) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (target[i][j] != arr[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;

        // Check 0° rotation
        if (checking(target, mat))
            return true;

        int[][] res = new int[n][m];
        int[][] res1 = new int[n][m];
        int[][] res2 = new int[n][m];

        // 90° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[m - 1 - j][i] = mat[i][j];
            }
        }

        // 180° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res1[m - 1 - j][i] = res[i][j];
            }
        }

        // 270° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res2[m - 1 - j][i] = res1[i][j];
            }
        }

        // Compare rotations
        if (checking(target, res))
            return true;
        if (checking(target, res1))
            return true;
        if (checking(target, res2))
            return true;

        return false;
    }
    public static void main(String[] args) {
        
    }
}
