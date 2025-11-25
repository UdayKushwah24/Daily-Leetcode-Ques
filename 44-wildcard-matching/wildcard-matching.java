class Solution {
    
    public static boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()]; // Use Boolean not boolean
        return pattern(dp, s, p, s.length() - 1, p.length() - 1);
    }

    public static boolean pattern(Boolean dp[][], String s, String p, int i, int j) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) { 
            return false;
        }

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        // check memoized value
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean ans;

        // match case
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = pattern(dp, s, p, i - 1, j - 1);
        }
        // star case
        else if (p.charAt(j) == '*') {
            ans = pattern(dp, s, p, i - 1, j) || pattern(dp, s, p, i, j - 1);
        } else {
            ans = false;
        }

        return dp[i][j] = ans;
    }

}