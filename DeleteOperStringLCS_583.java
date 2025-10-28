package DynamicProgramming;

public class DeleteOperStringLCS_583 {
    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";
        int[][] dp = new int[word1.length()][word2.length()];
        int lcs = LCS(dp, word1, word2, 0, 0);
        // System.out.println(LCS(dp,word1, word2, 0, 0 ));

        int deleteOperation = word1.length() - lcs + word2.length() - lcs;
        System.out.println(deleteOperation);
    }

    private static int LCS( int[][] dp,String word1, String word2, int i, int j) {

        if (i == word1.length() || j == word2.length()) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 1 + LCS(dp, word1, word2, i + 1, j + 1);

        } else {
            int f = LCS(dp, word1, word2, i + 1, j);
            int s = LCS(dp, word1, word2, i, j + 1);
            ans = Math.max(f, s);
        }
        return dp[i][j] = ans;
    }
}
