package Heap;
 
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMax_239 {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[arr.length - k+1 ];
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        int idx = 0;
        for (int i = k; i < arr.length; i++) {
            
        }
        
        return ans;
    }
     public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] +" ");
        }
    }
}
