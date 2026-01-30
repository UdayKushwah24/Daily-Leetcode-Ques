class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int persont = tickets[k];
        int n = tickets.length;
        for(int i = 0; i < n ; i++) {
            if(k == i) {
                q.add(-1);
            } else {
                q.add(tickets[i]);
            }
        }
        int ans = 0;

        while(!q.isEmpty()) {

            int tt = q.poll();
            if(tt == -1) {
                persont--;
                q.add(-1);
                if(persont == 0) {
                    return ans+1;
                }
            } else {
                tt--;
                if(tt != 0) {
                    q.add(tt);
                }
            }
            ans++;
        }
        return ans;
    }
}