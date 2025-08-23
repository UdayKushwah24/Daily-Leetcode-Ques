package Set;

import java.util.HashMap; 

public class ContainsDuplicate2_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true; // found duplicate within distance k
                }
            }
            map.put(nums[i], i); // update latest index
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 5, 1, 4, 2, 3, 14 };
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}