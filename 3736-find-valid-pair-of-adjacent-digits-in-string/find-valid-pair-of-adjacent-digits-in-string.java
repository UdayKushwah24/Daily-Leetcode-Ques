class Solution {
    public String findValidPair(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int k = (s.charAt(i)) - '0';
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }
        for (int i = 1; i < s.length(); i++) {
            int a = (s.charAt(i)) - '0';
            int b = (s.charAt(i - 1)) - '0';
            if (a != b && a == hm.get(a) && b == hm.get(b)) {
                return "" + s.charAt(i - 1) + s.charAt(i);
            }

        }
        return "";
    }
}