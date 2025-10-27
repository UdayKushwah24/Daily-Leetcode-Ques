class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        int n = num;
        while(n > 0) {
            int l  = n % 10;
            if(l % 2 == 0) even.add(l);
            else odd.add(l);
            n /= 10;
        }

        int ans = 0;
        int len = (num+"").length();
        String str = num+"";
        for(int i = 0; i < len;i++) {
            if((str.charAt(i)-'0') % 2 == 0) {
                ans = ans * 10 + even.poll();
            } else {
                ans = ans * 10 + odd.poll();

            }
        }
        return ans;
    }
}