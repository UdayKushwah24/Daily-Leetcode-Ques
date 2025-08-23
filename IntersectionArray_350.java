package Set;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionArray_350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int v = map.get(nums1[i]);
                map.put(nums1[i], v + 1);
            } else {
                map.put(nums1[i], 1);

            }
        }
        ArrayList<Integer> ll = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                ll.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        int[] ans = new int[ll.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        int[] ans = intersect(nums1, nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
