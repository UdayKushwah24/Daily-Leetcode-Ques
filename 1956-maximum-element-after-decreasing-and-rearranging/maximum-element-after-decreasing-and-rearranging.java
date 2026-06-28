class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];
        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }
        int maxElement = 0;
        for (int i = 1; i <= n; i++) {
            maxElement = Math.min(maxElement + counts[i], i);
        }
        return maxElement;
    }
}