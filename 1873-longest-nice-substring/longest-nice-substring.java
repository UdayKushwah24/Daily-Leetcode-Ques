class Solution {

    // Function to check if a string is nice
    public boolean Nice(String s) {
        int[] small = new int[26];
        int[] large = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                large[ch - 'A'] = 1;
            } else if (ch >= 'a' && ch <= 'z') {
                small[ch - 'a'] = 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            // Either only lowercase or only uppercase exists → not nice
            if ((small[i] == 1 && large[i] == 0) || (small[i] == 0 && large[i] == 1)) {
                return false;
            }
        }
        return true;
    }

    // Main function to find longest nice substring
    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (Nice(str) && str.length() > ans.length()) {
                    ans = str;
                }
            }
        }
        return ans;
    }
}
