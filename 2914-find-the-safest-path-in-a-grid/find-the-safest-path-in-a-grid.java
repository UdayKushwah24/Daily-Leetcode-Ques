class Solution {
    static int[] roww = {0, 0, 1, -1};
    static int[] coll = {1, -1, 0, 0};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int row = grid.size(), col = grid.get(0).size();
        if (grid.get(0).get(0) == 1 || grid.get(row - 1).get(col - 1) == 1) return 0;
        int[][] distance = new int[row][col];
        for (int[] d : distance) Arrays.fill(d, 9999);
        dist(distance, grid);
        int l = 0, r = distance[0][0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (find_val(mid, distance)) l = mid + 1;
            else r = mid - 1;
        }
        return l - 1;
    }
    public static void dist(int[][] distance, List<List<Integer>> grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (grid.get(i).get(j) == 1) {
                    distance[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + roww[i], nc = c + coll[i];
                if (nr >= 0 && nc >= 0 && nr < distance.length && nc < distance[0].length && distance[nr][nc] > distance[r][c] + 1) {
                    distance[nr][nc] = distance[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    static boolean find_val(int target, int[][] distance) {
        int[][] vis = new int[distance.length][distance[0].length];
        Queue<int[]> q = new LinkedList<>();
        vis[0][0] = 1;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + roww[i], nc = c + coll[i];
                if (nr >= 0 && nc >= 0 && nr < distance.length && nc < distance[0].length && vis[nr][nc] == 0 && distance[nr][nc] >= target) {
                    if (nr == distance.length - 1 && nc == distance[0].length - 1) return true;
                    vis[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}