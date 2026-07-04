class Solution {
    int ans = Integer.MAX_VALUE;

    class Edge {
        int u;
        int wt;

        Edge(int u, int wt) {
            this.u = u;
            this.wt = wt;
        }
    }

    void dfs(List<List<Edge>> graph, boolean[] visited, Edge curr, int dest) {
        int nodes = curr.u;
        visited[nodes] = true;

        for (Edge neigh : graph.get(nodes)) {
            ans = Math.min(ans, neigh.wt);

            if (!visited[neigh.u]) {
                dfs(graph, visited, neigh, dest);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            graph.get(r[0]).add(new Edge(r[1], r[2]));
            graph.get(r[1]).add(new Edge(r[0], r[2]));
        }

        boolean[] visited = new boolean[n + 1];
        Edge curr = new Edge(1, Integer.MAX_VALUE);

        dfs(graph, visited, curr, n);

        return ans;
    }
}