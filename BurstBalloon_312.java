package DynamicProgramming;

public class BurstBalloon_312 {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 8 };
        int[] a = new int[arr.length + 2];
        a[0] = a[a.length - 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            a[i + 1] = arr[i];
        }
        int[][] dp = new int[a.length][a.length];
        System.out.println(BurstCoin(dp,a, 0, a.length-1));
    }

    private static int BurstCoin(int[][] dp, int[] a, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = Integer.MIN_VALUE;
        for (int k = i + 1; k < j; k++) {
            int left = BurstCoin(dp,a, i, k);
            int right = BurstCoin(dp,a, k, j);
            int self = a[i] * a[j] * a[k];
            ans = Math.max(ans, left + right + self);
        }
        return dp[i][j] = ans;
    }
}
