import java.util.*;

class Solution {
    class BipartitePair {
        int vtx;
        int dis;

        public BipartitePair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Step 1: Build Graph (Adjacency List)
        int[][] graph = new int[n + 1][];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        // Step 2: Convert to array for your BFS method
        graph = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            List<Integer> list = adj.get(i);
            graph[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                graph[i][j] = list.get(j);
            }
        }

        // Step 3: Use your isBipartite logic (just skip index 0)
        return isBipartite(graph);
    }

    public boolean isBipartite(int[][] graph) {
        Queue<BipartitePair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 1; i < graph.length; i++) { // start from 1 (since graph is 1-indexed)
            if (visited.containsKey(i)) continue;

            q.add(new BipartitePair(i, 0));

            while (!q.isEmpty()) {
                // 1. remove
                BipartitePair rp = q.poll();

                // 2. Ignore if already visited
                if (visited.containsKey(rp.vtx)) {
                    if (visited.get(rp.vtx) != rp.dis) {
                        return false;
                    }
                    continue;
                }

                // 3. Mark visited
                visited.put(rp.vtx, rp.dis);

                // 4. Add unvisited neighbours
                for (int nbrs : graph[rp.vtx]) {
                    if (!visited.containsKey(nbrs)) {
                        q.add(new BipartitePair(nbrs, rp.dis + 1));
                    }
                }
            }
        }
        return true;
    }
}
