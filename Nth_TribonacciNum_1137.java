package DynamicProgramming;

public class Nth_TribonacciNum_1137 {

     

    public static int tribonacci(int n) {
        int[] dp = new int[n+1];
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }
}
