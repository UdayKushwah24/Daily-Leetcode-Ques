class Solution {
       public static String GetKey(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            sb.append('#');
            sb.append(freq[i]);
        }
        return sb.toString();
    }
    public   List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String key = GetKey(strs[i]);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        // for (List<String> val : map.values()) {
        //     list.add(val);
        // }
        return list;
        
    }

}