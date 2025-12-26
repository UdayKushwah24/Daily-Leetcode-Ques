class Solution {

    private static long reverseBits(long x, int bits) {
        long r = 0;
        for (int i = 0; i < bits; i++) {
            r = (r << 1) | ((x >> i) & 1L);
        }
        return r;
    }

    private static long buildPalindromeFromPrefix(long prefix, int L) {
        int half = (L + 1) / 2;
        if ((L & 1) == 0) { // even
            long right = reverseBits(prefix, half);
            return (prefix << half) | right;
        } else {
            long right = reverseBits(prefix >> 1, half - 1);
            return (prefix << (half - 1)) | right;
        }
    }

    private static long countLenLE(long n, int L) {
        if (L <= 0) return 0;

        long minL = 1L << (L - 1);
        if (n < minL) return 0;

        long maxL = (1L << L) - 1;
        int half = (L + 1) / 2;
        long start = 1L << (half - 1);

        if (n >= maxL) return 1L << (half - 1);

        long prefix = n >> (L - half);

        long count = prefix - start;
        if (count < 0) count = 0;

        long pal = buildPalindromeFromPrefix(prefix, L);
        if (pal <= n) count++;

        return count;
    }

    public int countBinaryPalindromes(long n) {
        if (n == 0) return 1;

        int L = Long.toBinaryString(n).length();

        long total = 1; // include 0
        for (int len = 1; len < L; len++) {
            int half = (len + 1) / 2;
            total += 1L << (half - 1);
        }

        total += countLenLE(n, L);

        return (int) total;
    }
}