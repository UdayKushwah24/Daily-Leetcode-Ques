class Solution {
    String[] w;
    String r;
    int[] mp = new int[26];   // char -> digit
    boolean[] usd = new boolean[10];
    boolean[] nz = new boolean[26]; // leading non-zero chars
    int mx;

    public boolean isSolvable(String[] words, String result) {
        w = words;
        r = result;
        Arrays.fill(mp, -1);

        for (String s : words) {
            if (s.length() > 1)
                nz[s.charAt(0) - 'A'] = true;
        }
        if (result.length() > 1)
            nz[result.charAt(0) - 'A'] = true;

        mx = result.length();
        for (String s : words)
            mx = Math.max(mx, s.length());

        return dfs(0, 0, 0);
    }

    private boolean dfs(int col, int row, int carry) {
        if (col == mx) {
            return carry == 0;
        }

        if (row == w.length) {
            int sum = carry;
            for (String s : w) {
                if (col < s.length()) {
                    sum += mp[s.charAt(s.length() - 1 - col) - 'A'];
                }
            }

            char rc = col < r.length()
                    ? r.charAt(r.length() - 1 - col)
                    : 0;

            int d = sum % 10;
            int nc = sum / 10;

            if (rc == 0) return false;

            int idx = rc - 'A';
            if (mp[idx] != -1)
                return mp[idx] == d && dfs(col + 1, 0, nc);

            if (usd[d] || (d == 0 && nz[idx])) return false;

            mp[idx] = d;
            usd[d] = true;

            if (dfs(col + 1, 0, nc)) return true;

            mp[idx] = -1;
            usd[d] = false;
            return false;
        }

        if (col >= w[row].length())
            return dfs(col, row + 1, carry);

        char c = w[row].charAt(w[row].length() - 1 - col);
        int idx = c - 'A';

        if (mp[idx] != -1)
            return dfs(col, row + 1, carry);

        for (int d = 0; d <= 9; d++) {
            if (usd[d] || (d == 0 && nz[idx])) continue;

            mp[idx] = d;
            usd[d] = true;

            if (dfs(col, row + 1, carry))
                return true;

            mp[idx] = -1;
            usd[d] = false;
        }
        return false;
    }
}
