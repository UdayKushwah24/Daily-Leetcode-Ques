class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int pair[] : edges) {
            int u = pair[0];
            int v = pair[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return dfs(source, destination, adjList);
    }

    public boolean dfs(int src, int des, ArrayList<ArrayList<Integer>> adjList) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        st.push(src);
        while (!st.isEmpty()) {
            //1.remove
            int r = st.pop();
            //Ignore 
            if (visited.contains(r)) {
                continue;
            }
            //mark visited
            visited.add(r);
            //self work
            if (r == des) {
                return true;
            }

            //add unvisited nbrs
            for (int nbrs : adjList.get(r)) {
                if (!visited.contains(nbrs)) st.push(nbrs);
            }
        }
        return false;
    }

}