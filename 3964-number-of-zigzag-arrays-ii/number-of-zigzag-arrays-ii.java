class Solution {
    final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int s = r - l + 1;
        long[][] baseMatrix = new long[s][s];
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                if(i + j < s - 1) {
                    baseMatrix[i][j] = 1;
                }
            }
        }

        long[][] result = new long[s][s];
        boolean empty = true;

        n--;
        while(n > 0) {
            if(n % 2 == 1) {
                if(empty) {
                    for(int i = 0; i < s; i++) {
                        result[i] = Arrays.copyOf(baseMatrix[i], s);
                    }
                    empty = false;
                } else {
                    result = multiply(result, baseMatrix);
                }
            }

            n /= 2;
            baseMatrix = multiply(baseMatrix, baseMatrix);
        }

        long sum = 0;
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                sum += result[i][j];
                sum %= MOD;
            }
        }
        sum *= 2;
        sum %= MOD;
        return (int) sum;
    }

    private long[][] multiply(long[][] matrixA, long[][] matrixB) {
        int s = matrixA.length;
        long[][] result = new long[s][s];
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                long sum = 0;
                for(int k = 0; k < s; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                    sum %= MOD;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
