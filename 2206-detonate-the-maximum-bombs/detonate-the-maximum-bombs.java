/* class Solution {
    class coordinates {
        int x;
        int y;
        int r;

        public coordinates(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public int maximumDetonation(int[][] bombs) {

        Queue<coordinates> q = new LinkedList<>();
        int ans = 1;
        int idx = 0;
        for (int bomb[] : bombs) {
            int x = bomb[0];
            int y = bomb[1];
            int r = bomb[2];
            q.add(new coordinates(x, y, r));
            ans = Math.max(ans, solve(idx,q, bombs));
            idx++;
            q.clear();
        }
        return ans;
    }

    public int solve(int idx, Queue<coordinates> q, int[][] bombs) {
        int count = 0;
        HashSet<String> vis = new HashSet<>();
        while (!q.isEmpty()) {

            coordinates rv = q.poll();
            String key = rv.x + "#" + rv.y + "#" + rv.r;
            if (vis.contains(key))
                continue;
            vis.add(key);
            explode(idx, rv, q, bombs);
            count++;
        }

        return count;
    }

    public void explode(int idx, coordinates rv, Queue<coordinates> q, int[][] bombs) {
        int x = rv.x;
        int y = rv.y;
        int r = rv.r;
        for (int i = 0; i < bombs.length; i++) {

            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];
            if (idx == i) continue;
            long dx = x - x1;
            long dy = y - y1;
            long dist = dx * dx + dy * dy;
            if (dist <= (long) r * r) {
                q.add(new coordinates(x1, y1, r1));
            }

        }
    }
} */

class Solution {
    class coordinates {
        int x;
        int y;
        int r;
        int idx;   // added

        public coordinates(int x, int y, int r, int idx) { // modified
            this.x = x;
            this.y = y;
            this.r = r;
            this.idx = idx;
        }
    }

    public int maximumDetonation(int[][] bombs) {

        Queue<coordinates> q = new LinkedList<>();
        int ans = 1;
        int idx = 0;

        for (int bomb[] : bombs) {
            int x = bomb[0];
            int y = bomb[1];
            int r = bomb[2];

            q.add(new coordinates(x, y, r, idx)); // modified
            ans = Math.max(ans, solve(q, bombs));
            idx++;
            q.clear();
        }

        return ans;
    }

    public int solve(Queue<coordinates> q, int[][] bombs) {

        int count = 0;
        HashSet<Integer> vis = new HashSet<>(); // modified

        while (!q.isEmpty()) {

            coordinates rv = q.poll();

            if (vis.contains(rv.idx)) continue; // modified
            vis.add(rv.idx);                    // modified

            explode(rv, q, bombs);
            count++;
        }

        return count;
    }

    public void explode(coordinates rv, Queue<coordinates> q, int[][] bombs) {

        int x = rv.x;
        int y = rv.y;
        int r = rv.r;

        for (int i = 0; i < bombs.length; i++) {

            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];

            long dx = x - x1;
            long dy = y - y1;

            long dist = dx * dx + dy * dy;

            if (dist <= (long) r * r) {
                q.add(new coordinates(x1, y1, r1, i)); // modified
            }
        }
    }
}