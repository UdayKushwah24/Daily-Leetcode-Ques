class Solution {
   public   int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]  = new int[triangle.size()][triangle.size()];
        for(int [ ] a : dp) {
            Arrays.fill(a, -111111);
        }
        return solve(dp,triangle, 0, 0);
    }

    private   int solve(int[][]dp, List<List<Integer>> triangle, int i, int j) {
        if(j > i) return 0;
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j] != -111111) return  dp[i][j];
        int d = triangle.get(i).get(j) + solve(dp, triangle, i+1, j);
        int dr = triangle.get(i).get(j) + solve(dp, triangle, i+1, j+1);
        return dp[i][j] = Math.min(d, dr);
    }
} 