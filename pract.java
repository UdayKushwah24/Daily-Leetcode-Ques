package DynamicProgramming;

import java.util.Arrays;

import Recursion.Hard.Coin;

public class pract {
    /*
     * public static void main(String[] args) {
     * String s1 = "abcde", s2 = "ace";
     * int dp[][] = new int[s1.length()][s2.length()];
     * for (int arr[] : dp) {
     * Arrays.fill(arr, -1);
     * }
     * System.out.println(LCS(s1, s2, 0, 0, dp));
     * }
     * 
     * private static int LCS(String s1, String s2, int i, int j, int[][] dp) {
     * 
     * if (i == s1.length() || j == s2.length()) {
     * return 0;
     * }
     * if (dp[i][j] != -1) {
     * return dp[i][j];
     * }
     * int ans = 0;
     * if (s1.charAt(i) == s2.charAt(j)) {
     * ans = 1 + LCS(s1, s2, i + 1, j + 1, dp);
     * } else {
     * int first = LCS(s1, s2, i + 1, j, dp);
     * int second = LCS(s1, s2, i, j + 1, dp);
     * ans = Math.max(first, second);
     * 
     * }
     * return dp[i][j] = ans;
     * }
     */
    /*
     * private static int LCSBU(String s1, String s2) {
     * int[][] dp = new int[s1.length() + 1][s2.length() + 1];
     * for (int i = 1; i < dp.length; i++) {
     * 
     * for (int j = 1; j < dp[0].length; j++) {
     * if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
     * dp[i][j] = 1 + dp[i - 1][j - 1];
     * } else {
     * int f = dp[i][j - 1];
     * int s = dp[i - 1][j];
     * dp[i][j] = Math.max(f, s);
     * }
     * 
     * }
     * 
     * }
     * for (int i = 0; i < dp.length; i++) {
     * for (int j = 0; j < dp[0].length; j++) {
     * System.out.print(dp[i][j] + " ");
     * }
     * System.out.println();
     * }
     * return dp[dp.length - 1][dp[0].length - 1];
     * }
     * 
     * public static void main(String[] args) {
     * String s1 = "abcde", s2 = "ace";
     * 
     * System.out.println(LCSBU(s1, s2));
     * }
     */

    /*
     * public static int CoinChangeTD(int[] coins, int amount, int i, int dp[][]) {
     * if (amount == 0) {
     * return 1;
     * }
     * if (i == coins.length) {
     * return 0;
     * }
     * if (dp[amount][i] != -1) {
     * return dp[amount][i];
     * }
     * int inc = 0, exc = 0;
     * if (amount >= coins[i]) {
     * inc = CoinChangeTD(coins, amount - coins[i], i, dp);
     * }
     * exc = CoinChangeTD(coins, amount, i + 1,dp);
     * return dp[amount][i]= inc + exc;
     * 
     * }
     * 
     * public static void main(String[] args) {
     * int[] coins = { 1, 2, 5 };
     * int amount = 5;
     * int dp[][] = new int[amount + 1][coins.length];
     * for (int[] a : dp) {
     * Arrays.fill(a, -1);
     * }
     * System.out.println(CoinChangeTD(coins, amount, 0, dp));
     * }
     */

    public static int CoinChangeTD(int[] coins, int amount, int i, int dp[][]) {
        

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        int dp[][] = new int[amount + 1][coins.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(CoinChangeTD(coins, amount, 0, dp));
    }
}
