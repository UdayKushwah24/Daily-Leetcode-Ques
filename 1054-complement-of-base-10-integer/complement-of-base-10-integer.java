class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int bit = 0;
        int x = n;
        while(x > 0) {
            bit++;
            x = x >> 1;
        }
        int mask = (1<<bit) - 1;
        return n ^ mask;
    }
}