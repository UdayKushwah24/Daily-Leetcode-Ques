/* class Solution {

    public String getKey(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : set) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public int similarPairs(String[] words) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        for (int val : map.values()) {
            if(val > 1)
            ans += (val * (val - 1)) / 2;
        }
        return ans;
    }
} */


class Solution {

    public int similarPairs(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (String s : words) {
            int mask = 0;
            for (char ch : s.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        for (int v : map.values()) {
            ans += (v * (v - 1)) / 2;
        }
        return ans;
    }
}
