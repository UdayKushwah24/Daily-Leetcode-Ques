class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(val, max);

        }
        int ans = 0;
        for (int val : map.values()) {
            if (val == max) {
                ans += val;
            }

        }
        return ans;

    }
}