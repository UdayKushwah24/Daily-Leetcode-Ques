class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 1; i <= 32; i++) {
            if((n & 1) != 0) {
                rev = (rev | (1 << (32-i)));
            }
            n >>=1;
        }
        return rev;
    }
}