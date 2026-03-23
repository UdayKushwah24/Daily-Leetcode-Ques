/* class Solution {
    long prod = Long.MIN_VALUE;
    int mod = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        solve(grid, m, n, 0, 0, 1);

        if (prod < 0) return -1;
        return (int)(prod % mod);
    }

    public void solve(int[][] grid, int m, int n, int i, int j, long pro) {

        if(i < 0 || j < 0 || i >= m || j >= n) return;

        pro = pro * grid[i][j];

        if(i == m-1 && j == n-1) {
            prod = Math.max(prod, pro);
            return;
        }

        solve(grid, m, n, i+1, j, pro); // down
        solve(grid, m, n, i, j+1, pro); // right
    }
} */


 class Solution {
    public static long picker(int n, int m, long prod, int[][] grid){
        if(n==0 && m==0) return prod*grid[0][0]; 
        if(prod==0) return 0;
        
        long up = (n!=0) ? picker(n-1,m,prod*grid[n][m],grid) : Long.MIN_VALUE;
        long left = (m!=0) ? picker(n,m-1,prod*grid[n][m],grid) : Long.MIN_VALUE;

        return Math.max(up,left);
    }
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long ans = picker(n-1,m-1,1,grid);
        return ans<0 ? -1 : (int)(ans % 1000000007);
    }
}