package Set;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramString_438 {

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

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ll = new ArrayList<>();
        int k = p.length();
        for (int i = 0; i < s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (is_Anagram(sub, p)) {
                ll.add(i);
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
