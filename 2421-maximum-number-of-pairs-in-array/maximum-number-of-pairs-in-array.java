class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums) {
           map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int pair = 0;
        int rem = 0;
        for(int v : map.values()) {
            if(v % 2 == 0) {
                pair += v/2;
            } else {
                pair += v/2;
                rem++;
            }
        }
        return new int[]{pair, rem};
    }
}