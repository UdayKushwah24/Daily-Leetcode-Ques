package Heap;

import java.util.*;
public class Prioriy_Queue {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        pq.add(3);
        pq.add(5);
        pq.add(9);
        pq.add(1);
        System.out.println(pq);
        


    }
}
