package InfinityChampionsProgram.Day3;
import java.util.*;
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int minc = 0;
        int maxc = matrix[0].length - 1;
        int minr = 0;
        int maxr = matrix.length - 1;
        int te = matrix[0].length * matrix.length;
        int count = 0;
        while (count < te) {
            for (int i = minc; i <= maxc && count < te; i++) {
                list.add(matrix[minr][i]);
                count++;
            }
            minr++;
            for (int i = minr; i <= maxr && count < te; i++) {
                list.add(matrix[i][maxc]);
                count++;
            }
            maxc--;
            for (int i = maxc; i >= minc && count < te; i--) {
                list.add(matrix[maxr][i]);
                count++;
            }
            maxr--;
            for (int i = maxr; i >= minr && count < te; i--) {
                list.add(matrix[i][minc]);
                count++;
            }
            minc++;
        }
        return list;
    }
}