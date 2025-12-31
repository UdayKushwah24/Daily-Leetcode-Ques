class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
         HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            map.get(v).add(u);
        }
        for (int i = 0; i < queries.length; i++) {
            int des = queries[i][0];
            int src = queries[i][1];
            ans.add(checkPath(map, src, des));
        }

        return ans;
    }

     public static Boolean checkPath(HashMap<Integer, List<Integer>> map, int src, int des) {
        int n = map.size();
        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()) {
            // 1. remove
            int rv = stack.pop();

            // 2. check if already visited
            if(vis.contains(rv)) {
                continue;
            }

            // 3. mark visited
            vis.add(rv);

            // 4. self work
            if(rv == des) return true;


            // 5. Add unvisited neighbour
            for(int nbrs : map.get(rv)) {
                if(!vis.contains(nbrs)) {
                    stack.push(nbrs);
                }
            }
        }
        return false;
    }
}