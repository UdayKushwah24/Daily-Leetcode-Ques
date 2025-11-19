class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i < nums.length;i++) {
            set.add(nums[i]);
        }
        if(!set.contains(original)) {
            return original;
        }
        int sum = original;
        while(true) {
            original *= 2;
            if(set.contains(original)) {
                sum = original;
            } else {
                break;
            }
        }
        return 2*sum;
         
    }
}