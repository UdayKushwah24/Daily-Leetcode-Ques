class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (idx < n) { 
                    ans[idx++] = 0;
                }
                if (idx < n) {
                    ans[idx++] = 0;
                }
            } else {
                if (idx < n)
                    ans[idx++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++)
            arr[i] = ans[i];
    }
}