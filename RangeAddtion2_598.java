package InfinityChampionsProgram.Day3;

import java.util.HashMap;

public class RangeAddtion2_598 {
    public static int maxCount(int m, int n, int[][] ops) {
        int mat[][] = new int[m][n];
        for (int i = 0; i < ops.length; i++) {
            int s = ops[i][0];
            int e = ops[i][1];
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < e; k++) {
                    mat[j][k]++;
                }
            }
        }
        
    }
}
