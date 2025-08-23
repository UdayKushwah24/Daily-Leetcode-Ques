package Set;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagram_49 {
    public static boolean isAnagram(String s, String t) {
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

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> ll = new ArrayList<>();
            ll.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {

                if (isAnagram(strs[i], strs[j])) {
                    ll.add(strs[j]);
                }  
            }
            if (!ll.isEmpty() || ll.size() > 1) {
                list.add(ll);
            }
          
        }
        return list;
    }
    public static void main(String[] args) {
        String[] ans = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(ans));
    }
}
