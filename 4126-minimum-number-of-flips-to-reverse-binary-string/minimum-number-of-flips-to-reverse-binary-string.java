class Solution {
    public int minimumFlips(int n) {
        int ans = 0;
        
        int idx = 0;
        int x = n;
        while(x > 0) {
            idx++;
            x >>= 1;
        }
        int p = 0;
        x = n;
        for(int i = idx-1; i >= 0; i--) {
            int msb = n & (1 << i);
            if(msb > 0) {
                msb = 1;
            }
            int lsb = (x & 1);
            if(lsb != msb) {
                ans++;
            }
            x>>= 1;
        }
        return ans;
    }
}