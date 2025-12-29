class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numIslands = 0;
        for (int[] u : stones){
            if (!visited.contains(u)){
               dfs(u, visited, stones); 
               numIslands++;
            }
        }
        return stones.length - numIslands;
    }
    
    private void dfs(int[] u, Set<int[]> visited, int[][] stones){
        visited.add(u);
        for (int[] v: stones){
            if (!visited.contains(v)){
				// stone with same row or column. group them into island
                if (u[0] == v[0] || u[1] == v[1]) {
                    dfs(v, visited, stones);
                }
            }
        }
    }
}
