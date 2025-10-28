// https://leetcode.com/discuss/post/1282577/selling-wine-dp-easy-c-by-vidhuv9-oemr/

package DynamicProgramming;

import java.util.*;

public class WineProblem {
    /*
     * public static void main(String[] args) {
     * int wine[] = { 2, 3, 5, 1, 4 };
     * int year = 1;
     * System.out.println(MaxProfit(wine, 0, wine.length-1, year));
     * }
     * 
     * 
     * 
     * private static int MaxProfit(int[] wine, int i, int j, int year) {
     * if (i > j) {
     * return 0;
     * }
     * int fb = wine[i] * year + MaxProfit(wine, i + 1, j, year + 1);
     * int lb = wine[j] * year + MaxProfit(wine, i, j - 1, year + 1);
     * return Math.max(fb, lb);
     * }
     */

    /*
     * public static void main(String[] args) {
     * int wine[] = { 2, 3, 5, 1, 4 };
     * int year = 1;
     * int[][] dp = new int[wine.length ][wine.length ];
     * for (int a[] : dp) {
     * Arrays.fill(a,-1);
     * }
     * System.out.println(MaxProfit(dp,wine, 0, wine.length - 1, year));
     * }
     * 
     * private static int MaxProfit(int[][] dp , int[] wine, int i, int j, int year)
     * {
     * if (i > j) {
     * return 0;
     * }
     * if (dp[i][j] != -1) {
     * return dp[i][j];
     * }
     * int fb = wine[i] * year + MaxProfit(dp ,wine, i + 1, j, year + 1);
     * int lb = wine[j] * year + MaxProfit(dp,wine, i, j - 1, year + 1);
     * return dp[i][j] = Math.max(fb, lb);
     * }
     */

    public static void main(String[] args) {
        int wine[] = { 2, 3, 5, 1, 4 };

        System.out.println(MaxProfitBU(wine));
    }

    private static int MaxProfitBU(int[] wine) {
        int year = wine.length;

        int[][] dp = new int[wine.length][wine.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = wine[i] * year;
        }
        // year--;
        // for (int gap = 1; gap < dp.length; gap++) {
        //     for (int j = gap; j < dp.length; j++) {
        //         int i = j +gap;
        //         int fs = wine[i] * year + dp[i - 1][j];
        //         int ls = wine[j] * year + dp[i][j - 1];
        //         dp[i][j] = Math.max(fs, ls);

        //     }
        //     year = year - 1;
        // }

        // Fill dp table gap by gap
        int n = year;
        for (int gap = 1; gap < n; gap++) {
             year = n - gap;
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;

                int fs = wine[i] * year + dp[i + 1][j];
                int ls = wine[j] * year + dp[i][j - 1];

                dp[i][j] = Math.max(fs, ls);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][dp.length - 1];

    }
}
