class Solution {
    public int closestTarget(String[] w, String t, int s) {
        int n = w.length;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(w[i].equals(t)) {
                int d = Math.abs(i - s);
                int cd = Math.min(d, n - d); // circular distance
                ans = Math.min(ans, cd);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}