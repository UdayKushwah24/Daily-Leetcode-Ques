package Set;

import java.util.HashMap;

public class LongestConsecutiveSeq_128 {
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }
            if (map.containsKey(nums[i] + 1)) {
                map.put(nums[i] + 1, false);
            }
        }
        System.out.println(map);
        for (int key : map.keySet()) {
            if (map.get(key)) {
                int count = 0;
                while (map.containsKey(key)) {
                    count++;
                    key++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 7, 4, 1, 8, 9, 15, 13, 16, 3 };
        // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums));
    }

    /*
     * public static int longestConsecutive(int[] nums) {
     * int ans = 0;
     * HashMap<Integer, Integer> map = new HashMap<>();
     * for (int i = 0; i < nums.length; i++) {
     * map.put(nums[i], 0);
     * }
     * for (int key : map.keySet()) {
     * int count = 0;
     * while (map.containsKey(key + 1)) {
     * count++;
     * key++;
     * }
     * ans = Math.max(count, ans);
     * }
     * 
     * 
     * return ans;
     * }
     * 
     * public static void main(String[] args) {
     * int[] nums = { 2, 5, 7, 4, 1, 8, 9, 15, 13, 16, 3 };
     * // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
     * System.out.println(longestConsecutive(nums));
     * }
     */
}
