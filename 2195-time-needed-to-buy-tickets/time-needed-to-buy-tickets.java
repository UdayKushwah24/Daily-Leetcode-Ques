/* class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int kthPerson = tickets[k];
        for(int i = 0; i < tickets.length; i++) {
            if(i == k) {
                q.add(-1);
            }
            q.add(tickets[i]);
        }
        int sec = 0;

        while(!q.isEmpty()) {
            
            sec++;
            int first = q.poll();
            if(first == -1) {
                kthPerson -= 1;
                q.add(-1);
                if(kthPerson == 0) {
                    return sec;
                }
                 
                
            }
            
            
            first = first - 1;
           if(first != 0) {
                q.add(first);
            }

        }
        return 0;
    }
} */


class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int kthPerson = tickets[k];
        for(int i = 0; i < tickets.length; i++) {
            if(i == k) {
                q.add(-1);
            } else {

            q.add(tickets[i]);
            }
        }
        int sec = 0;

        while(!q.isEmpty()) {
            
            sec++;
            int first = q.poll();
            if(first == -1) {
                kthPerson--;
                q.add(-1);
                if(kthPerson == 0) {
                    return sec;
                }  
            }            
           else {
                first = first - 1;
                if(first > 0)
                q.add(first);
            }

        }
        return 0;
   
    }
}