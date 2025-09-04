package DynamicProgramming;
 
import java.util.Arrays;

public class RobberHouseII_198 {

    // Using Recursion
    /*
     * public static void main(String[] args) {
     * int arr[] = { 7, 5, 3, 13, 1 };
     * System.out.println(Robber(arr,0));
     * }
     * 
     * private static int Robber(int[] arr, int i) {
     * if (i >= arr.length) {
     * return 0;
     * }
     * int rob = arr[i] + Robber(arr, i + 2);
     * int donot_rob = Robber(arr, i + 1);
     * 
     * return Math.max(rob, donot_rob);
     * 
     * }
     */

    public static void main(String[] args) {
        int arr[] = { 7, 5, 3, 13, 1 };
        int[] dp = new int[arr.length];
        // for (int i = 0; i < dp.length; i++) {
        // dp[i] = -1;
        // }
        Arrays.fill(dp, -1);
        System.out.println(RobberTD(arr, 0, dp));
        System.out.println(RobberTD2(arr, arr.length - 1, dp));

    }

    private static int RobberTD(int[] arr, int i, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int rob = arr[i] + RobberTD(arr, i + 2, dp);
        int donot_rob = RobberTD(arr, i + 1, dp);
        return dp[i] = Math.max(rob, donot_rob);
    }

    private static int RobberTD2(int[] arr, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int rob = arr[i] + RobberTD2(arr, i - 2, dp);
        int donot_rob = RobberTD2(arr, i - 1, dp);
        return dp[i] = Math.max(rob, donot_rob);
    }

    public static int RobberBU(int[] arr ) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0] =  arr[0] ;
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < dp.length; i++) {
            int rob = arr[i] + dp[i - 2];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[dp.length - 1];
    }
}