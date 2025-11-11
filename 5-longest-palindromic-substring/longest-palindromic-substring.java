class Solution {
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
}