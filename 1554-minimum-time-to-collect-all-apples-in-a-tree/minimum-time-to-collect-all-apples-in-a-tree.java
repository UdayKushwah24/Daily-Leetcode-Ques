class Solution {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfs(graph, 0, -1, hasApple);

    }

    public static int dfs(HashMap<Integer, List<Integer>> graph, int curr, int parent, List<Boolean> hasApple) {
        int time = 0;
        for (int child : graph.get(curr)) {
            if (child == parent)
                continue;
            int time_from_child = dfs(graph, child, curr, hasApple);
            if (time_from_child > 0 || hasApple.get(child)) {
                time += time_from_child + 2;
            }
        }
        return time;
    }

}
