class Solution {
    public int majorityElement(int[] nums) {
        int v = 1;
        int ele = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(ele == nums[i]) {
                v++;
            } else {
                v--;
                if(v < 0) {
                    ele = nums[i];
                    v = 1;
                }
            }
        }
        return ele;
    }
}