/* class Solution {
    static int answer = Integer.MAX_VALUE;
    public static void Coin(int[] coin,int amount, String ans,int idx, int count) {
        if(amount == 0) {
            answer = Math.min(answer,count);
            // if(answer > count) {
            //     answer = count;
            // }
            System.out.println(ans);
            return;
        }
        for(int i=idx;i <coin.length;i++) {
            if(amount >= coin[i]) {
                Coin(coin,amount-coin[i], ans+coin[i],i,count+1);
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        Coin(coins,amount,"",0,0);
        if(answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }
} */

class Solution {
    
    public int coin(int[][] dp, int[] coins, int amount, int i) {
        if(amount == 0) return 0;
        if(i >= coins.length || amount < 0) {
            return (int)1e9;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        int inc = 0, exc = 0;
        inc = 1 + coin(dp, coins, amount-coins[i], i);
        exc = coin(dp, coins, amount, i+1);
        return dp[i][amount] = Math.min(inc, exc);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        int answer  = coin(dp, coins,amount,0);
        if(answer >= (int)1e9) {
            return -1;
        } else {
            return answer;
        }
    }
}