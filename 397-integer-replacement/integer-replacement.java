class Solution {

    public int integerReplacement(int n) {
        return solve((long) n);   // small change to avoid overflow
    }

    public int solve(long n) {

        if (n == 1) {
            return 0;            // FIX 1: base case
        }

        if (n % 2 == 0) {
            return 1 + solve(n / 2);   // FIX 2: add 1 step
        } else {
            return 1 + Math.min(
                    solve(n - 1),
                    solve(n + 1)
            );                          // FIX 3: correct logic
        }
    }
}
