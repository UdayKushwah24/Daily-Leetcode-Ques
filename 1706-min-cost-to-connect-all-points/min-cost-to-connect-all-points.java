class Solution {
   
    class PrimsPair {
        int vtx;
        int cost;

        public PrimsPair(int vtx, int cost) {
            this.vtx = vtx;
          
            this.cost = cost;
        }

    }

    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                map.get(i).put(j, cost);
                map.get(j).put(i, cost);
            }
        }

        int cost = 0;
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        HashSet<Integer> visited = new HashSet<>();

        pq.add(new PrimsPair(0, 0));

        while (!pq.isEmpty()) {
            // 1. remove
            PrimsPair rem = pq.poll();

            // 2. Ignore if already visited
            if (visited.contains(rem.vtx)) {
                continue;
            }

            // 3. mark visited
            visited.add(rem.vtx);

            // 4. self work
            cost += rem.cost;

            // 5. Add unvisited neighbours
            for(int nbrs : map.get(rem.vtx).keySet()) {
                if(!visited.contains(nbrs)) {
                    int c = map.get(rem.vtx).get(nbrs);
                    pq.add(new PrimsPair(nbrs, c));
                }
            }
        }
        return cost;

    }
}
