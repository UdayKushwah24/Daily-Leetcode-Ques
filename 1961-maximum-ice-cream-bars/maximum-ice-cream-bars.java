/* class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for(int i = 0; i < costs.length; i++) {
            if(coins >= costs[i]) {
                ans++;
                coins -= costs[i];
            }  
        }
        return ans;
    }
} */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int i = 0;
        while(i < costs.length && coins >= costs[i]) {
            ans++;
            coins -= costs[i];
            i++;
        }
        return ans;
    }
}