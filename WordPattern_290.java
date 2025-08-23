package Map;

import java.util.*;

public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String s) {
        LinkedHashMap<Character, String> map = new LinkedHashMap<>();
        String[] arr = s.trim().split(" ");
        HashSet<String> set = new HashSet<>();
        System.out.println(arr.length+" "+pattern.length());
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (set.contains(arr[i])) {
                    return false;
                }
                map.put(ch, arr[i]);
                set.add(arr[i]);
            } else {
                String val = map.get(ch);
                if (!val.equals(arr[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abca";
        System.out.println(wordPattern(pattern, s));
    }
}