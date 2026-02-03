class Solution {

    int ans;
    int tgt;
    int[][] dp;

    public int minimizeTheDifference(int[][] mat, int target) {
        ans = Integer.MAX_VALUE;
        tgt = target;

        int m = mat.length;
        int maxSum = 5000; // constraints based

        dp = new int[m][maxSum + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int n = mat[0].length;
        for (int col = 0; col < n; col++) {
            solve(mat, 0, 0, col);
        }
        return ans;
    }

    public void solve(int[][] mat, int sum, int cr, int cc) {

        sum += mat[cr][cc];

        

        if (cr == mat.length - 1) {
            ans = Math.min(ans, Math.abs(tgt - sum));
            return;
        }

        if (dp[cr][sum] != -1) {
            return;  
        }

        dp[cr][sum] = Math.abs(tgt - sum);

        for (int i = 0; i < mat[0].length; i++) {
            solve(mat, sum, cr + 1, i);
        }
    }
}
