class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ll = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0;i < n; i++) {
             if(!map.containsKey(nums[i])) map.put(nums[i], 1);
             else map.put(nums[i], map.get(nums[i])+1);
        }

        int i = 0;
        for(int k : map.keySet()) {
            int val = map.get(k);
            if(val > 2) {
                val = 2;
            }
            while(val-->0) {
                ll.add(k);
                i++;
            }
        }
        // Collections.sort(ll);
        for(int j = 0; j < ll.size(); j++) {
            nums[j] = ll.get(j);
        }
        return ll.size();
    }
}