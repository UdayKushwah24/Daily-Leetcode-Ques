class Solution {
    public int findCenter(int[][] edges) {
        for(int i = 0; i < edges.length; i++){
            if(edges[0][0] == edges[1][0]) return edges[0][0];
            if(edges[0][0] == edges[1][1]) return edges[0][0];
            if(edges[0][1] == edges[1][0]) return edges[1][0];
            if(edges[0][1] == edges[1][1]) return edges[0][1];
        }
        return -1;
    }
}