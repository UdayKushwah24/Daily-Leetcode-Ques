package Heap;

 
import java.util.PriorityQueue;

public class MaxProd_1464 {
    public static int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(nums[0]-1);
        pq.add(nums[1]-1);
        for (int i = 2; i < nums.length; i++) {
            if (pq.peek() < nums[i]-1) {
                pq.poll();
                pq.add(nums[i]-1);
            }
        }
        return pq.poll() * pq.poll();
    }
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };
        System.out.println(maxProduct(nums));
    }
}