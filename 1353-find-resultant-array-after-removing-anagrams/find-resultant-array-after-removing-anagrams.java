class Solution {

    public static String GetKey(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(freq[i]);
        }
        return sb.toString();
    }

    public List<String> removeAnagrams(String[] strs) {
        List<String> ans = new ArrayList<>();

        String prevKey = "";
        for (int i = 0; i < strs.length; i++) {
            String key = GetKey(strs[i]);
            if (!key.equals(prevKey)) {
                ans.add(strs[i]);
                prevKey = key;
            }
        }
        return ans;
    }
}
