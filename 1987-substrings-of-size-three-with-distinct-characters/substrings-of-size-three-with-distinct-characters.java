class Solution {
    public int countGoodSubstrings(String s) {
        int ans= 0;
        for(int i = 0; i < s.length()-2; i++) {
            int f = s.charAt(i);
            int se = s.charAt(i+1);
            int t = s.charAt(i+2);
            if(f != se && se != t && f != t) ans++;
        }
        return ans;
    }
}