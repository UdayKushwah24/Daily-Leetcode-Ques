class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (sb.length() == 0 || sb.toString().charAt(sb.length() - 1) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }
        int ans = -1;
        for (String k : map.keySet()) {
            if (map.get(k) >= 3) {
                ans = Math.max(ans, k.length());
            }
        }

        return ans;
    }
}