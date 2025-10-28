package DynamicProgramming;

public class MinASCIIDelete_712 {

    public static void main(String[] args) {
        String word1 = "delete", word2 = "leet";
        // String word1 = "sea", word2 = "eat";
        int[][] dp = new int[word1.length()][word2.length()];
         LCS(dp, word1, word2, 0, 0);
        
         System.out.println(s);
         int asciiSumWord1 = 0;
         int asciiSumWord2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            asciiSumWord1 += word1.charAt(i);
        }
        for (int i = 0; i < word2.length(); i++) {
            asciiSumWord2 += word2.charAt(i);
        }
        int lcsAscii = 0;
        for (int i = 0; i < s.length(); i++) {
            lcsAscii += s.charAt(i);
        }
        int ascii = asciiSumWord1 - lcsAscii + asciiSumWord2 - lcsAscii;
        System.out.println(ascii);


    }
 
    static String s = "";
    private static int LCS(int[][] dp, String word1, String word2, int i, int j) {

        if (i == word1.length() || j == word2.length()) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            s = s + word1.charAt(i);
            ans = 1 + LCS(dp, word1, word2, i + 1, j + 1);
            System.out.print(word1.charAt(i));

        } else {
            
            int f = LCS(dp, word1, word2, i + 1, j);
            
            int s = LCS(dp, word1, word2, i, j + 1);
            ans = Math.max(f, s);
        }
        return dp[i][j] = ans;
    }
}