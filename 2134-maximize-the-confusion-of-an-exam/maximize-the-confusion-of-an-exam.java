class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        return Math.max(longestOnes(s, k, 'T'), longestOnes(s, k, 'F'));
    }

      public int longestOnes(String nums, int k, char ch) {
           int si = 0, ei = 0, len = 0, flip = 0;
        while (ei < nums.length()) {

            // grow
            if (nums.charAt(ei) == ch) {
                flip++;
            }

            // shrink
            while (si <= ei && flip > k) {
                if (nums.charAt(si) == ch) {
                    flip--;
                }
                si++;
            }

            len = Math.max(len, ei - si + 1);
            ei++;
        }
        return len;
    }
}