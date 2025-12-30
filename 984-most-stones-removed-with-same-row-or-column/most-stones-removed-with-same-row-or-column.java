class Solution {
   public static int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];

        int group = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            dfs(stones, i, visited);
            group++;
        }
        return n - group;
    }

    private static void dfs(int[][] stones, int index, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < stones.length; i++) {
            int r = stones[index][0];
            int c = stones[index][1];
            if (!visited[i] && (stones[i][0] == r || stones[i][1] == c)) {
                 dfs(stones, i, visited);
            }
        }
    }
}
