class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
         int n=online.length;
        List<int[]>[]graph=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }   
       int r=0;
        for (int[] d : edges) {
            int u=d[0];
            int v=d[1];
            int cost=d[2];
            r=Math.max(cost, r);
            if(online[u]&&online[v]){
                graph[u].add(new int[]{v,cost});
            }
        }
        int l=0;
        int ans=-1;
        while (l<=r) {
            int mid=(l+r)/2;
            if(check(graph,mid,n)<=k){
                l=mid+1;
                ans=mid;
            }else{
                r=mid-1;
            }
               System.out.println("now ans="+ans);
        }
        return ans;
    }
     private long check(List<int[]>[]graph,int mid,int n){
        long[]dis=new long[n];
         Arrays.fill(dis, (long)5e13+1);
        Queue<long[]>que=new ArrayDeque<>();
        que.add(new long[]{0l,0l});
        dis[0]=0;
        HashMap<Integer,Long>map=new HashMap<>();
        map.put(0, 0l);
        while (!que.isEmpty()) {
            long[]cur=que.poll();
            int from=(int)cur[0];
            long cost=cur[1];
            if(cost>dis[from]){
                continue;
            }
            for (int[] ne : graph[from]) {
                int next=ne[0];
                int next_cost=ne[1];
                 if(next_cost>=mid&&dis[next]>(long)cost+(long)next_cost){
                    dis[next]=(long)cost+(long)next_cost;
                    que.add(new long[]{next,cost+next_cost});
                }
            }
        }
        return dis[n-1];
    }
}