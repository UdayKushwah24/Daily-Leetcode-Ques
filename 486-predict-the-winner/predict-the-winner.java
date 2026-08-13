/*  

class Solution {
     public   boolean predictTheWinner(int[] arr) {

        int total = Arrays.stream(arr).sum();
        
        int player1 = OptimalGame(arr, 0, arr.length-1);
        int player2 = total - player1;

        return (player1 >= player2);
    }

    private   int OptimalGame(int[] arr, int i, int j) {


         if (i > j) {
            return 0;
        }
        int take_i = arr[i] + Math.min(OptimalGame(arr, i + 2, j), OptimalGame(arr, i + 1, j - 1));
        int take_j = arr[j] + Math.min(OptimalGame(arr, i + 1, j - 1), OptimalGame(arr, i, j - 2));
        
        return Math.max(take_i, take_j);
    }
 
}  */
/* 
class Solution {
  public   boolean predictTheWinner(int[] arr) {

        int total = Arrays.stream(arr).sum();
        int dp[][] = new int[arr.length][arr.length];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        int player1 = OptimalGame(dp, arr, 0, arr.length - 1);
        int player2 = total - player1;

        return (player1 >= player2);
    }

    private   int OptimalGame(int dp[][] ,int[] arr, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = arr[i] + Math.min(OptimalGame(dp,arr, i + 2, j), OptimalGame(dp,arr, i + 1, j - 1));
        int take_j = arr[j] + Math.min(OptimalGame(dp,arr, i + 1, j - 1), OptimalGame(dp,arr, i, j - 2));

        return dp[i][j] = Math.max(take_i, take_j);
    }
 
} */

class Solution {
   public   boolean predictTheWinner(int[] arr) {

        int dp[][] = new int[arr.length][arr.length];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        int diff = OptimalGame(dp,arr, 0, arr.length - 1);

        return (diff >= 0);
    }

    private   int OptimalGame(int[][] dp,int[] arr, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = arr[i] - OptimalGame(dp,arr, i + 1, j);
        int take_j = arr[j] - OptimalGame(dp, arr, i, j - 1);

        return dp[i][j] = Math.max(take_i, take_j);
    }
} 
