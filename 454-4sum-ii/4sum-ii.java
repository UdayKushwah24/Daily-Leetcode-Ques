class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: store all sums of nums1 & nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        int count = 0;

        // Step 2: check complementary sums from nums3 & nums4
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }

        return count;
    }
}
