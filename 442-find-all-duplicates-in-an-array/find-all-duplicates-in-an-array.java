class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                lst.add(nums[i]);
            }
        }
        return lst;
    }
}