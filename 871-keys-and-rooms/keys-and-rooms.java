class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()) {
            // 1. remove
            int rv = q.poll();

            // 2. Ignore if already visited
            if(visited[rv]) continue;

            // 3. mark visited
            visited[rv] = true;
            // 4. self work


            // 5. Add unvisited neighbours
            for(int i = 0; i < rooms.get(rv).size(); i++) {
                if(!visited[rooms.get(rv).get(i)]) {
                    q.add(rooms.get(rv).get(i));
                }
            }

        }
        for(int i = 0; i < n ;i++) {
            if(visited[i] == false) {
                return false;
            } 
        }

        return true;
    }
}