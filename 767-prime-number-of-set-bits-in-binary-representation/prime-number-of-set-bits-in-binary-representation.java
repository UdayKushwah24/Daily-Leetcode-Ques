class Solution {

    public boolean CheckPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int countBit(int i) {
        int c = 0;
        while (i > 0) {
            c++;
            i = (i & (i-1));
        }
        return c;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (CheckPrime(countBit(i))) {
                count++;
            }
        }
        return count;
    }
}