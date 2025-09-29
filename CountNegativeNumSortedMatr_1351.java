package InfinityChampionsProgram.Day3;

public class CountNegativeNumSortedMatr_1351 {

    public static int countNegatives(int[][] grid) {

        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            int arr[] = grid[i];
            int idx = firstNegative(arr);
            c += arr.length-idx;
        }
        return c;
    }

    
    private static int firstNegative(int[] arr) {
        int l = 0, h = arr.length-1;
        int idx = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] < 0) {
                idx = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (idx == -1) {
            return arr.length;
        }
        return idx;
    }


    public static void main(String[] args) {
        int[][] grid = { { 3, 2}, {1,0 } };
        // int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(countNegatives(grid));
    }
}
