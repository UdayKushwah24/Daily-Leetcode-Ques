class Solution {
    public int[] findOriginalArray(int[] ch) {
        int n = ch.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(ch);
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int x : ch)
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int[] ans = new int[n / 2];
        int idx = 0;

        for (int x : ch) {
            if (!mp.containsKey(x) || mp.get(x) == 0) continue;

            // 🔥 ZERO SPECIAL CASE
            if (x == 0) {
                if (mp.get(x) < 2) return new int[0];
            }

            int d = x * 2;
            if (!mp.containsKey(d) || mp.get(d) == 0)
                return new int[0];

            if (idx >= ans.length) return new int[0]; // safety

            ans[idx++] = x;

            mp.put(x, mp.get(x) - 1);
            mp.put(d, mp.get(d) - 1);
        }

        return ans;
    }
}
