class Solution {
    public int reverseBits(int n) {
        int c=0;
        int i=32;
        while(i-->0)
        {
            c<<=1;
            c=c | (n&1);
            n=n>>1;

        }
        return c;
    }
}