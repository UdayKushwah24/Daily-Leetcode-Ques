class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n=arr.length;
        long ans=0;
        int vis[]=new int[n];
        for(int i=0;i<n;i++){
            List<Integer>list=new ArrayList<>();
            if(vis[i]==1)
            continue;
            while(vis[i]==0){
                vis[i]=1;
                list.add(arr[i]);
                i=(i+k)%n;
            }
            Collections.sort(list);
            for(int j:list){
                ans+=Math.abs(j-list.get(list.size()/2));
            }
        }
        return ans;
    }
}