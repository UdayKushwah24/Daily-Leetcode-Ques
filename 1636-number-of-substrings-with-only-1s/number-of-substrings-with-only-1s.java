/* class Solution {
    public int numSub(String s) {
     
        int i = 0;
        long ans = 0;
        int mod = 1000000007;
        while (i < s.length()) {
            int c = 0;
            while (i < s.length() && s.charAt(i) == '1') {
                c++;
                i++;
            }

            ans += (c * (c + 1)) / 2;
            ans = ans % mod;

            i++;
        }
        return (int)ans;
    }
} */


class Solution {
    public int numSub(String s) {
        long cnt = 0;   // Length of current consecutive '1's
        long total = 0; // Total valid substrings
        long mod = 1000000007;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++; // Increase length of current '1's block
            } else {
                cnt = 0; // Reset on '0'
            }
            
            // Add the number of new substrings ending at index i
            total = (total + cnt) % mod;
        }
        return (int) total;
    }
}