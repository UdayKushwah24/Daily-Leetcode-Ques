package DynamicProgramming;

public class UncrossedLines_1035 {
    private static int LCSBU(int[] s1, int[] s2) {
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {
                if (s1[i-1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int f = dp[i][j - 1];
                    int s = dp[i - 1][j];
                    dp[i][j] = Math.max(f, s);
                }

            }

        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        return LCSBU(nums1, nums2);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 2 };
        int[] nums2 = { 1, 2, 4 };
        System.out.println(maxUncrossedLines(nums1, nums2));
    }
}
