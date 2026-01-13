class Solution {
    public int maximumDifference(int[] prices) {
        int n = prices.length;
        int max[] = new int[n];
        int min[] = new int[n];
        min[0] = prices[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i-1], prices[i]);
        }
        max[n-1] = prices[n-1];
        for(int i = n-2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], prices[i]);
        }
        int profit = 0;
        for(int i = 0; i < n ; i++) {
            profit = Math.max(profit, max[i] - min[i]);

        }
        return profit == 0 ? -1 : profit;

    }
}