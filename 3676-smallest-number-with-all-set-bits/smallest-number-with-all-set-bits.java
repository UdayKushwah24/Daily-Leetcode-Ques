class Solution {
    public int smallestNumber(int n) {
        int bit = 0;
        while(n > 0) {
            bit++;
            n /= 2;
        }

        return (int)Math.pow(2, bit)-1;
    }
}