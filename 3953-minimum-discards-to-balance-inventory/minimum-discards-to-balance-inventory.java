class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = arrivals.length;
        int i = 0, j = 0;
        int cnt = 0;
        while (j < n) {
            int aj = arrivals[j];
            mpp.put(aj, mpp.getOrDefault(aj, 0) + 1);
            if (mpp.get(aj) > m) {
                cnt++;
                int newVal = mpp.get(aj) - 1;
                if (newVal <= 0) mpp.remove(aj);
                else mpp.put(aj, newVal);
                arrivals[j] = 0;
            }
            if (j - i + 1 == w) {
                int ai = arrivals[i];
                int cur = mpp.getOrDefault(ai, 0) - 1;
                if (cur <= 0) mpp.remove(ai);
                else mpp.put(ai, cur);
                i++;
            }
            j++;
        }
        return cnt;
    }
}