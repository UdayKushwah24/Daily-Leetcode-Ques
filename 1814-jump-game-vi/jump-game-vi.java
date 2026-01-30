// class Solution {
//     public int maxResult(int[] nums, int k) {
//         int n = nums.length, a= 0, b=0;
//         int[] deq = new int[n];
//         deq[0] = n-1;
//         for(int i = n-2; i>=0;i--){
//             if(deq[a] - i > k){
//                 a++;
//             }
//             nums[i] += nums[deq[a]];
//             while(b >= a && nums[deq[b]] <= nums[i]){
//                 b--;
//             }
//             deq[++b]=i;
//         }
//         return nums[0];
//     }
// }
/* class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        pq.offer(new int[]{0, nums[0]});
        for(int i = 1; i < n ; i++) {
            while(i - pq.peek()[0] > k) {
                pq.poll();
            } 
            int top[] = pq.peek();
            max = nums[i] + top[1];
            pq.offer(new int[]{i, max});
        }
        return max;
    }
} */



class Solution {
    public int maxResult(int[] nums, int k) {
        int max = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        pq.offer(new int[]{0 , nums[0]});
        for(int i = 1; i < nums.length; i++) {
            while(i - pq.peek()[0] > k) {
                pq.poll();
            }
            int [] top = pq.peek();
            max = nums[i] + top[1];
            pq.offer(new int[]{i, max});
        }
        return max;
    }
}