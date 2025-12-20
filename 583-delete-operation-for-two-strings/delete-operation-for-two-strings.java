/* class Solution {
    public int minDistance(String s1, String s2) {
       int max=0;
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return s1.length()+s2.length()-2*dp[s1.length()][s2.length()];
    }
} */

 

class Solution {
    public int minDistance(String word1, String word2) {
         int[][] dp = new int[word1.length()][word2.length()];
        int lcs = LCS(dp, word1, word2, 0, 0);
        
        int deleteOperation = word1.length() - lcs + word2.length() - lcs;
        return deleteOperation;
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
 