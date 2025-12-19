class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        boolean cycleFound = false;

        while (N > 0) {
            String key = Arrays.toString(cells);

            if (seen.containsKey(key)) {
                int cycleLength = seen.get(key) - N;
                N %= cycleLength;
                cycleFound = true;
            }

            if (N > 0) {
                seen.put(key, N);
                cells = nextDay(cells);
                N--;
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return next;
    }
}