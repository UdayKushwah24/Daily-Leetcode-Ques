import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        int totalCost = 0;
        
        // Sort in ascending order first: O(N log N)
        Arrays.sort(cost);

        int l = cost.length;
        int numThree = l / 3;
        int modThree = l % 3;

        // Start from the end of the array (the highest values)
        int pos = l - 1;

        // Step 1: Process complete triplets from right to left
        for (int i = 0; i < numThree; i++) {
            int firstCandy = cost[pos];
            totalCost = totalCost + firstCandy;
            pos--;
            
            int secondCandy = cost[pos];
            totalCost = totalCost + secondCandy;
            pos -= 2; // Skip the third candy (it's free!)
        }

        // Step 2: Accumulate any remaining candies
        for (int i = 0; i < modThree; i++) {
            int candy = cost[pos];
            totalCost = totalCost + candy;
            pos--;
        }

        return totalCost;        
    }
}