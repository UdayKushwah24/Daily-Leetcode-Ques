package InfinityChampionsProgram.Day1;

import java.util.Comparator;
import java.util.PriorityQueue;

 
public class SlidingWidowMaximum_239 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int ans[] = maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    
    static class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
       
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                // return p1.val - p2.val;
                return p2.val - p1.val;
            }
        });
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        ans[0] = pq.peek().val;
       
        for (int j = k; j < arr.length; j++) {
            while (pq.size() > 0 && pq.peek().idx <= (j - k)) {
                pq.poll();
            }
            pq.add(new Pair(arr[j], j));
            ans[j - k+1] = pq.peek().val;
        }



        return ans;
    }
}
  