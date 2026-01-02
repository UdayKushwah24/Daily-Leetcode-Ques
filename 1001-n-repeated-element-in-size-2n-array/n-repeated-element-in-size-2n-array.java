class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : nums) {
            if(!map.containsKey(e)) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e)+1);
               if(map.get(e) == nums.length/2) return e;
            }
        }
        return -1;
    }
}