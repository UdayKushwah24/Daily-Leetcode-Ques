class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i , new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int v1 = prerequisites[i][0];
            int v2 = prerequisites[i][1];
            map.get(v2).add(v1);
        }
        int in[] = new int[numCourses];
        for(int vtx : map.keySet()) {
            for(int nbrs : map.get(vtx)) {
                in[nbrs]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        int c = 0;
        int ans[] = new int[numCourses] ;
        int idx = 0;
        while(!q.isEmpty()) {
            int v = q.poll();
            c++;
            ans[idx++] = v;
            for(int nbrs : map.get(v)) {
                in[nbrs]--;
                if(in[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        return numCourses == c ?  ans : new int[]{};
    }
}