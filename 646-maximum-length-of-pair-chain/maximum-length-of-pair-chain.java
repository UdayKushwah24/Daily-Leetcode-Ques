class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->a[1]-b[1]);
        arr = pairs;
        n = arr.length;
        dp = new int[n+1][n+1];
        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        return solve(0, -1);
    }

    int arr[][];
    int dp[][];
    int n;
    public int solve(int i, int prev) {
        if(i >= n){
            return 0 ;
        }
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        int take = 0;
        if(prev == -1 || arr[prev][1] < arr[i][0]) {
            take = 1 + solve(i+1, i);
        }
        int skip = solve(i+1, prev);
        if(prev != -1) dp[i][prev] =  Math.max(take, skip);
        return Math.max(take, skip);
    }
    
}



















// class Solution {
//     public int findLongestChain(int[][] pairs) {
//          Arrays.sort(pairs, (a, b)->a[1]-b[1]);

//         int count  =1;
//         int last = pairs[0][1];
//         for (int i = 1; i < pairs.length; i++) {
//             if(pairs[i][0] > last) {
//                 count++;
//                 last = pairs[i][1];
//             }
//         }
       
//         return  count;

//     }
// }