package DynamicProgramming;
 
 
public class pract {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(minPathSum(grid, 0, i), ans);

            System.out.println(ans);
        }
        System.out.println(ans);
    }
 
    public static int minPathSum(int[][] arr, int i, int j) {
        
        if ( j <0 || j >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == arr.length - 1 ) {
            return arr[i][j];
        }
        int ld = minPathSum(arr, i + 1, j - 1);
        int rd = minPathSum(arr, i + 1, j + 1);
        int b = minPathSum(arr, i + 1, j );
        return arr[i][j] + Math.min(b, Math.min(ld, rd));
    }
}