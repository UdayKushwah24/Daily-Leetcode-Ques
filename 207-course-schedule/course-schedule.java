class Solution {
  

    private HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int g[] : prerequisites) {
            int u = g[0];
            int v = g[1];
            graph.get(v).add(u);
        }
        int[] in = indegree();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if(in[i] == 0) q.add(i);
        }
        int c = 0;
        while(!q.isEmpty()) {
            int rv = q.remove();
            c++;
            for(int nbrs : graph.get(rv)) {
                in[nbrs]--;
                if(in[nbrs] == 0) q.add(nbrs);
            }
        }
        return  c == numCourses;
    }

    public int[] indegree() {
        int[] in = new int[graph.size()];
        for (int u : graph.keySet()) {
            for (int v : graph.get(u)) {
                in[v]++;
            }
        }

        return in;
    }

}
