package Heap;

import java.util.PriorityQueue;

public class KthLargestEleArray_215 {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 6, 2, 6, 4, 3, 3, 2, 2, 3, 5, 6 };
        int k = 4;
        System.out.println(Kth_Largest_Element(nums, k));
    }

    // TC : k x log(n)
    private static int Kth_Largest_Element(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
