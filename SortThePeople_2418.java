package Map;

import java.util.ArrayList;
import java.util.*;
public class SortThePeople_2418 {
    public static String[] sortPeople(String[] names, int[] heights) {
        
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);

        }
        System.out.println(map);
        String[] ans = new String[names.length];
        int i = ans.length - 1;
        for (int key : map.keySet()) {
           ans[i] = map.get(key);
           i--;
        }
        return ans;
    }
}