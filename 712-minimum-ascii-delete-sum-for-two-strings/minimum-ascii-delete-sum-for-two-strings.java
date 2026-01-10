/* class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int ascii_s1 = 0;
        int ascii_s2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            ascii_s1 += (int) s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            ascii_s2 += (int) s2.charAt(i);
        }
        String lcs = longestCommonSubsequence(s1, s2);
        int ascii_lcs = 0;
        for (int i = 0; i < lcs.length(); i++) {
            ascii_lcs += (int) (lcs.charAt(i));
        }
        return ascii_s1 + ascii_s2 - 2 * ascii_lcs;

    }

    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack to build LCS string
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

} */



class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

      
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                   
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int sum1 = 0, sum2 = 0;

        for (char c : s1.toCharArray()) sum1 += c;
       
        for (char c : s2.toCharArray()) sum2 += c;
  


        return sum1 + sum2 - 2 * dp[0][0];
    }
}
