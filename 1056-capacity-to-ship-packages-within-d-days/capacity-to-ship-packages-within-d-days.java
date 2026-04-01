class Solution {
    public static boolean possible(int[] weights, int capacity,int days) {
        int ans = 0;
        int n = weights.length;
        for(int i  = 0; i < n;i++) {
            if(ans + weights[i] > capacity) {
                days--;
                ans = 0;
            }
            ans += weights[i];
        }
        return days > 0;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = 0;
       
        while(l <= r){
            int mid = l + (r-l)/2;
            if(possible(weights, mid, days)) {
                ans = mid;
                r = mid  - 1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}