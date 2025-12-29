class Solution {
    public int alternatingSum(int[] nums) {
        boolean flag = true;
        int ans = 0;
        for(int e : nums) {
            if(flag) ans += e;
            else ans -= e;
            flag = !flag;
        }
        return ans;
    }
}