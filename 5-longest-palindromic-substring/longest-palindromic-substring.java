/* class Solution {
     public static boolean CheckPalindrome(String str){
        int n = str.length();
        int i = 0;
        int j = n-1;
        boolean isPalindrome = true;
        while(i <= j) {
            if(str.charAt(i)!=str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }
    public static String longestPalindrome(String str) {
        int maxLength = 0;
        String longPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String sub = str.substring(i, j+1);
                if( CheckPalindrome(sub)) {
                    int currentLength = sub.length();
                    if(currentLength > maxLength) {
                        maxLength = currentLength;
                        longPalindrome  = sub;
                    }
                }
            }
        }
        return longPalindrome;
    }
} */


public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}