class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q ; i++) {
            ans[i] = solve(queries[i][0], queries[i][1]);
        }
        return ans;
    }
    public int solve(int x, int y) {

        int count = 1;
        while(x != y) {
            if(x > y) {
                x = x/2;
            } else {
                y = y/2;
            }
            count++;
        }
        return count;
    }
}