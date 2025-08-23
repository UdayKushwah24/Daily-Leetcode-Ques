// leetcode : https://leetcode.ca/all/1167.html

package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinSumPair_CodeSkiller {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(MinSumPair(arr));
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = sc.nextInt();
        // }
        // System.out.println(MinSumPair(arr));
        // sc.close();

    }

    private static int MinSumPair(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a + b);

        }
        return sum;
    }
}
