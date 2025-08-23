// Ques  : https://leetcode.ca/all/253.html

package Heap;
import java.util.*;
public class MeetingRoom2_253 {
    public static void main(String[] args) {
        int[][] intervals = { { 10, 30 }, { 5, 10 }, { 15, 20 }, { 2, 6 }, { 12, 18 }, { 19, 25 }, { 1, 5 }, { 3, 5 } };
        // Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        // for (int i = 0; i < intervals.length; i++) {
        //     System.out.println(intervals[i][0] + " -> " + intervals[i][1]);
        // }
        System.out.println(MeetingRoom2(intervals));
    }

    private static int MeetingRoom2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(intervals[0]); 
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()[1]) {
                pq.poll();
                pq.add(intervals[i]);
            } else {
                pq.add(intervals[i]);
            }
        }


        return pq.size();
    }
}
