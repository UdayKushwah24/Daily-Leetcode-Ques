class Solution {
    long mod = 1000000007;
    public int countHousePlacements(int n) {
        long dp[] = new long[n];
        Arrays.fill(dp, -1);
        long x = placeHouse(dp, n, 0) ;
         
        return (int)((x * x)%mod);
    }


    private   long placeHouse(long[] dp, int n, int i) {
        if(i >= n) {
            return 1;
        }
        if(dp[i] != -1) return dp[i];
         

        long place_House = placeHouse(dp, n, i+2) % mod;
        long notPlaceHouse = placeHouse(dp , n, i+1) % mod;
        return dp[i] =( place_House + notPlaceHouse) % mod;
    }
}