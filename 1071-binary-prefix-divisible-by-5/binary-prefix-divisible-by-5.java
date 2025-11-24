class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int mod=0;
        for(int n: nums){
            mod = (2*mod + n ) % 5;
            ans.add( mod == 0);
        }
        return ans;
    }
}