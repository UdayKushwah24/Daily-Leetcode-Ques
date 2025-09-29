package InfinityChampionsProgram.Day3;

import java.util.*;

public class SetMatrixZeros_73 {

    public static void setZeroes(int[][] matrix) {
        List<int[]> ll = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    ll.add(new int[] { i, j });
                }
            }
        }        
        for (int i = 0; i < ll.size(); i++) {
            int r = ll.get(i)[0];
            int c = ll.get(i)[1];
            Arrays.fill(matrix[r], 0);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][c] = 0;
            }
        }

    }

    public static void main(String[] args) {
        // int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
