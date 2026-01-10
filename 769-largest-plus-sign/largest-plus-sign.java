import java.util.*;

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
 
        int[][] A = new int[N][N];

        // Step 1: Fill matrix with 1s
        for (int i = 0; i < N; i++) {
            Arrays.fill(A[i], 1);
        }

        // Step 2: Place mines (0s)
        for (int[] m : mines) {
            A[m[0]][m[1]] = 0;
        }

        int order = 0;

        // Step 3: Try every cell as center
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (A[i][j] == 0)
                    continue;

                int left = 0, right = 0, top = 0, bottom = 0;
                int k;

                // left
                k = j;
                while (k >= 0 && A[i][k] == 1) {
                    left++;
                    k--;
                }

                // right
                k = j;
                while (k < N && A[i][k] == 1) {
                    right++;
                    k++;
                }

                // top
                k = i;
                while (k >= 0 && A[k][j] == 1) {
                    top++;
                    k--;
                }

                // bottom
                k = i;
                while (k < N && A[k][j] == 1) {
                    bottom++;
                    k++;
                }

                int currOrder = Math.min(
                        Math.min(left, right),
                        Math.min(top, bottom)

                );

                order = Math.max(order, currOrder);
            }
        }

        return order;
    }
}
