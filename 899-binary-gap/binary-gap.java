class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        boolean set = false;
        int c = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                set = true;
                c = 1;
                
            }
            if (set && ((n & 1) == 0)) {
                c++;
            }
            n >>= 1;
            if ((n & 1) != 0) {
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}