package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO_502 {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < arr.length;) {
            while (i < arr.length && w >= arr[i][0]) {
                pq.add(arr[i]);
                i++;
            }
            if (pq.isEmpty() || k == 0) {
                return w;
            }
            w += pq.poll()[1];
            k--;

        }
        while (!pq.isEmpty() && k > 0) {
            w += pq.poll()[1];
            k--;
        }

        return w;
    }
    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = { 1, 2, 3 }, capital = { 0, 1, 1 };
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
