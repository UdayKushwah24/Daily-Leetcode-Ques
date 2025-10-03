package InfinityChampionsProgram.Day6;

import java.util.*;

public class ModifyTheMatrix_3033 {

    public static int[][] modifiedMatrix(int[][] matrix) {
        List<int[]> list = new ArrayList<>();

        int arr[] = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {

                if (matrix[i][j] == -1) {
                    list.add(new int[] { i, j });
                }
                max = Math.max(max, matrix[i][j]);
            }
            arr[j] = max;
        }
        for (int i = 0; i < list.size(); i++) {
            int r = list.get(i)[0];
            int c = list.get(i)[1];
            matrix[r][c] = arr[c];

        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}
