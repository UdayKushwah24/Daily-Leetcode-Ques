package DynamicProgramming.Basic;

public class Fibonacci {
    /*
     * public static void main(String[] args) {
     * int n = 7;
     * for (int i = 0; i <=n; i++) {
     * System.out.print(fibonacci(i)+" ");
     * }
     * }
     * 
     * private static int fibonacci(int n) {
     * if (n == 0 || n == 1)
     * return n;
     * int f1 = fibonacci(n - 1);
     * int f2 = fibonacci(n - 2);
     * return f1+f2;
     * }
     */

    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n + 1];
        System.out.println(fibDP(n, dp));
        for (int i = 1; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    // recursive approach
    /*
     * 
     * private static int fibTD(int n, int[] dp) {
     * if (n == 0 || n == 1)
     * return n;
     * if (dp[n] != 0) { // dp aaply kiya hai
     * return dp[n];
     * }
     * int f1 = fibTD(n - 1,dp);
     * int f2 = fibTD(n - 2,dp);
     * // return dp[n] = f1+f2; // yaad kiya hai
     * dp[n] = f1+f2; // yaad kiya hai
     * return f1+f2;
     * }
     */


    // bottom up approach
    private static int FibBU(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
