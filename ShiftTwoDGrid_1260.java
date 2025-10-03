package InfinityChampionsProgram.Day6;

import java.util.*;

public class ShiftTwoDGrid_1260 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ShiftGrid(grid);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> ll = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                ll.add(grid[i][j]);
            }
            list.add(ll);
        }
        return list;
    }

    private static void ShiftGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m * n];
        arr[0] = grid[m - 1][n - 1];
        int x = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(x < m*n)
                arr[x++] = grid[i][j];
            }
        }

        x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = arr[x++];
            }
        }



    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        int k = 4;
        System.out.println(shiftGrid(grid, k));

    }
}