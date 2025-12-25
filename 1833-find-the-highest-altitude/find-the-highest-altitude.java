class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0;
        int maxnum = 0;
        for(int i : gain){
            cur += i;
            maxnum = Math.max(maxnum, cur);
        }
        return maxnum;
    }
}