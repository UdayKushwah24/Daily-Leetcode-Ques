package Set;

import java.util.HashMap;

public class anagram_242 {

    /*
     * public static boolean isAnagram(String s, String t) {
     * if (s.length() != t.length()) {
     * return false;
     * }
     * HashMap<Character, Integer> map1 = new HashMap<>();
     * for (int i = 0; i < s.length(); i++) {
     * char ch = s.charAt(i);
     * if (map1.containsKey(ch)) {
     * int rv = map1.get(ch);
     * map1.put(ch, rv + 1);
     * } else {
     * map1.put(ch, 1);
     * }
     * }
     * System.out.println(map1);
     * HashMap<Character, Integer> map2 = new HashMap<>();
     * for (int i = 0; i < t.length(); i++) {
     * char ch = t.charAt(i);
     * if (map2.containsKey(ch)) {
     * int rv = map2.get(ch);
     * map2.put(ch, rv + 1);
     * } else {
     * map2.put(ch, 1);
     * }
     * }
     * 
     * for (char key : map1.keySet()) {
     * int val = map1.get(key);
     * if (map2.containsKey(key) && map2.get(key) == val) {
     * continue;
     * } else {
     * return false;
     * }
     * }
     * System.out.println(map2);
     * 
     * return true;
     * }
     */

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            if (map1.containsKey(ch1)) {
                int rv = map1.get(ch1);
                map1.put(ch1, rv + 1);
            } else {
                map1.put(ch1, 1);
            }
            char ch2 = t.charAt(i);
            if (map2.containsKey(ch2)) {
                int rv = map2.get(ch2);
                map2.put(ch2, rv + 1);
            } else {
                map2.put(ch2, 1);
            }
        }
        System.out.println(map1);

        System.out.println(map2);

        for (char key : map1.keySet()) {
            int val = map1.get(key);
            if (!map2.containsKey(key)) {
                return false;
            }
            if (map2.get(key) != val) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean is_Anagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26]; // fixed size array instead of HashMap

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
