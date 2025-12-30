class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            indegree[trust[i][1]]++;
            outdegree[trust[i][0]]++;
        }
        int judge = -1;
        for (int i = 1; i < outdegree.length; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                judge = i;
                break;
            }
        }
        return (judge);
    }
}