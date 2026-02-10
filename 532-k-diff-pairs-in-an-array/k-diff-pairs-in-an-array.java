class Solution {
    public int findPairs(int[] nums, int k) {
        int pair = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        if(k == 0){
            for(int val : freq.values()){
                if(val >= 2)pair++;
            }
        }else{
            for(int num : freq.keySet()){
                if(freq.containsKey(num+k))pair++;
            }
        }
        return pair;
    }
}