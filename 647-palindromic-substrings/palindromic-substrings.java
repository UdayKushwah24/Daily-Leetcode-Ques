class Solution {
    public int countSubstrings(String s) {
        return CountPalindrome(s);
    }

    public static int CountPalindrome(String s) {

        // count the odd no. of palindromic substring
        int countOdd = 0;
        for (int axis = 0; axis < s.length(); axis++) {
            for (int orbit = 0; (axis-orbit >= 0 && axis+orbit < s.length()); orbit++) {
                if(s.charAt(axis-orbit) != s.charAt(axis+orbit)) {
                    break;
                }
                countOdd++;
            }
        }
        // count the even no. of palindromic substring
        int countEven = 0;
        for (double axis = 0.5; axis < s.length(); axis++) {
            for (double orbit = 0.5; (axis-orbit >= 0 && axis+orbit < s.length()); orbit++) {
                if(s.charAt((int)(axis-orbit)) != s.charAt((int)(axis+orbit))) {
                    break;
                }
                countEven++;
            }
        }
        
        return countOdd+countEven;

    }

}