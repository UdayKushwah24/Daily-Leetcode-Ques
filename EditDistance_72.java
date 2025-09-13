package DynamicProgramming;

import java.util.Arrays;

public class EditDistance_72 {

    // public static int minOperation(String s, String t, int i, int j) {
    //     if (i == s.length()) {
    //         return t.length() - j;
    //     }
    //     if (j == t.length()) {
    //         return s.length() - i;
    //     }
    //     int ans = 0;

    //     if (s.charAt(i) == t.charAt(j)) {
    //         ans = 1 + minOperation(s, t, i + 1, j + 1);
    //     } else {
    //         int delete = minOperation(s, t, i + 1, j);
    //         int remove = minOperation(s, t, i + 1, j + 1);
    //         int insert = minOperation(s, t, i, j + 1);
    //         ans = Math.min(remove, Math.min(delete, insert)) + 1;
    //     }
    //     return ans;
    // }

    // public static int operation(String s, String t, int i, int j) {
    //     if (i == s.length()) {
    //         return t.length() - j;
    //     }
    //     if (j == t.length()) {
    //         return s.length() - i;
    //     }
    //     int ans = 0;
    //     if (s.charAt(i) == t.charAt(j)) {
    //         ans = operation(s, t, i + 1, j + 1); // dp[i-1][j-1]

    //     } else {
    //         int delete = operation(s, t, i + 1, j); // dp[i-1][j]
    //         int insert = operation(s, t, i, j + 1); // dp[i][j-1]
    //         int replace = operation(s, t, i + 1, j + 1); // dp[i-1][j-1]
    //         ans = 1 + Math.min(delete, Math.min(insert, replace));
    //     }
    //     return ans;
    // }


    public static int operationBU(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i ;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    ans = dp[i - 1][j - 1];   
                } else {
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    ans = 1 + Math.min(delete, Math.min(insert, replace));
                }
                dp[i][j] = ans;
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

    public static void main(String[] args) {
        String s = "intention", t = "execution";
    //     int[][] dp = new int[s.length() + 1][t.length() + 1];
    //     for (int[] a : dp) {
    //         Arrays.fill(a, -1);
    //     }
    //     System.out.println(minOperation(s, t, 0, 0));


        System.out.println(operationBU(s, t));
    }
}