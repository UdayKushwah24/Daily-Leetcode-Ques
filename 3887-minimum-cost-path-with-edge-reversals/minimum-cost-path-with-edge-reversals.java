class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> ans=new ArrayList<>();
        List<List<int[]>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
            {
                ans.add(new ArrayList<>());
                res.add(new ArrayList<>());
            }
        for(int i=0;i<edges.length;i++)
            {
                int a=edges[i][0];
                int b=edges[i][1];
                int cost=edges[i][2];
                ans.get(a).add(new int[]{b,cost});
                res.get(b).add(new int[]{a,cost*2});
            }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        int vis[]=new int[n];
        q.add(new Pair(0,0L));
        long d[]=new long[n];
        Arrays.fill(d,Long.MAX_VALUE);
        d[0]=0;
        while(!q.isEmpty())
            {
                Pair top=q.poll();
                int u=top.a;
                long c=top.cost;
                if(c>d[u])continue;
                if(u==n-1) return (int)c;
                for(int r[]:ans.get(u))
                    {
                        int v=r[0];
                        int w=r[1];
                        if(d[u]+w<d[v])
                        {
                            d[v]=d[u]+w;
                            q.add(new Pair(v,d[v]));
                        }
                    }
                for(int r[]:res.get(u))
                    {
                        int v=r[0];
                        int w=r[1];
                        if(d[u]+w<d[v])
                        {
                            d[v]=d[u]+w;
                            q.add(new Pair(v,d[v]));
                        }
                    }
            }
        return -1;
    }
}
class Pair{
    int a;
    long cost;
    Pair(int a,long cost)
    {
        this.a=a;
        this.cost=cost;
    }
}