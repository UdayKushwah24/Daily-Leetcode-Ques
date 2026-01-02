class Solution {
    public int minimumEffortPath(int[][] heights) {

        // max ko min karna hai
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] rm = pq.poll();
            int x = rm[0];
            int y = rm[1];
            int dis = rm[2];
            if (x == m - 1 && y == n - 1)
                return dis;
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newcost = Math.max(dis, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newcost < dist[nx][ny]) {
                        dist[nx][ny] = newcost;
                        pq.add(new int[] { nx, ny, newcost });
                    }
                }
            }
        }
        return -1;
    }
}