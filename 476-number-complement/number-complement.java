class Solution {
    public int findComplement(int n) {
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