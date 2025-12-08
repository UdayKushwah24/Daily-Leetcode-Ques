class Solution {
    public int countTriples(int n) {
        int c = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= n; k++) {
                    if (i*i + j*j == k*k) {
                        c += 1;
                    }
                    if (i*i == j*j + k*k) {
                        c += 1;
                    }
                    if (i*i + k * k == j*j) {
                        c += 1;
                    }
                }
            }
        }
        return c;
    }
}