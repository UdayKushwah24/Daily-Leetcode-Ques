class Solution {
    public static boolean check(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i) || s1.charAt(n-i-1) != s2.charAt(m-i-1)) return false;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int ans  = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(words[i].length() <= words[j].length() && check(words[i], words[j])) ans++;
            }
        }

        return ans;
    }
}