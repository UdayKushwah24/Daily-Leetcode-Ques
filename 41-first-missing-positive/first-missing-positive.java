 
class Solution {
     
    public int firstMissingPositive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // if(num > 0)
            seen.add(num);  
        }

        int ans = 0;
        for (int i = 1; i <= nums.length+1; i++) {
            if (!seen.contains(i)) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}