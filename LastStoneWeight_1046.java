package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public static int lastStoneWeight(int[] stones) {
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        System.out.println(pq);
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(Math.abs(x - y));
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }
}