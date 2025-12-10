class Solution {
 

    public int countPermutations(int[] comp) {
        int n = comp.length;
        int first = comp[0];
        int MOD = 1_000_000_007;
        // Check that first is the unique minimum
        for (int i = 1; i < n; i++) {
            if (comp[i] <= first) return 0;
        }

        // Compute factorial (n-1)!
        long fact = 1;
        for (int i = 2; i < n; i++) {
            fact = (fact * i) % MOD;
        }

        return (int) fact;
    }
}