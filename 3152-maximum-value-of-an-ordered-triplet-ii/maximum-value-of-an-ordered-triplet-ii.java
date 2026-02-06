class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        long maxa = 0;
        long maxb = 0;
        for(int a : nums) {
            res = Math.max(res , (long)maxb * a);
            maxb = Math.max(maxb, maxa - a);
            maxa = Math.max(maxa, a);
        }
        return res;
    }
}