package Set;

import java.util.TreeMap;

public class SortCharacterByFreq_451 {
    public static String frequencySort(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        // TreeMap<Integer, Character> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int rv = map.get(ch);
                map.put(ch, rv + 1);
            } else {
                map.put(ch, 1);

            }
        }
        System.out.println(map);

        for (char key : map.keySet()) {
            int r = map.get(key);
            while (r > 0) {
                sb.append(key);
                r--;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "aabb";
        // String s = "tree";
        System.out.println(frequencySort(s));
    }
}
