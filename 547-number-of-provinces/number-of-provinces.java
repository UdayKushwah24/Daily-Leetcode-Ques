class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer  > visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int provines = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited.contains(i)) {
                continue;
            }
            provines++;
            q.add(i);
            while(!q.isEmpty()) {
                // 1. remove
                int rv = q.poll();

                // 2. ignore if already visited
                if(visited.contains(rv)) continue;

                // 3. marked visited
                visited.add(rv);

                // 4. self work

                // add unvisited nbrs
                for(int nbrs = 0; nbrs < isConnected[rv].length; nbrs++) {
                    if(isConnected[rv][nbrs] == 1 && !visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
        return provines;

    }
}