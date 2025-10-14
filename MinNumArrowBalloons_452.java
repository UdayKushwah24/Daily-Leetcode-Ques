package InfinityChampionsProgram.Day1;

import java.util.Arrays;

public class MinNumArrowBalloons_452 {
    
    /*
     * public static int findMinArrowShots(int[][] points) {
     * Arrays.sort(points, (a, b) -> a[0] - b[0]);
     * for (int i = 0; i < points.length; i++) {
     * for (int j = 0; j < points[0].length; j++) {
     * System.out.print(points[i][j] + " ");
     * }
     * System.out.println();
     * }
     * 
     * int psp = points[0][0]; // previous starting point
     * int pep = points[0][1]; // previous ending point
     * int arrow = 1;
     * for (int i = 1; i < points.length; i++) {
     * int csp = points[i][0];
     * int cep = points[i][1];
     * if (csp > pep) { // no-overlap
     * arrow++;
     * psp = csp;
     * pep = cep;
     * } else { // overlap
     * psp = Math.max(psp, csp);
     * pep = Math.min(pep, cep);
     * }
     * 
     * }
     * return arrow;
     * }
     * public static void main(String[] args) {
     * int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
     * System.out.println(findMinArrowShots(points));
     * }
     */
    public static int findMinArrowShots1(int[][] points) {
        if (points.length <= 1)
            return points.length;

        // Safe sort by starting point
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int arrows = 1;
        int prevStart = points[0][0];
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if (currStart > prevEnd) { // no overlap
                arrows++;
                prevStart = currStart;
                prevEnd = currEnd;
            } else { // overlap
                prevStart = Math.max(prevStart, currStart);
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        return arrows;
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
         
        int prev[] = points[0];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {

            int csp = points[i][0];
            int cep = points[i][1];

            int psp = prev[0]; // previous starting point
            int pep = prev[1]; // previous ending point

            if (csp > pep) { // no overlap
                arrows++;
                prev = points[i];
            } else { // overlap

                // overlapping region
                prev[0] = Math.max(psp, csp);
                prev[1] = Math.min(pep, cep);
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(findMinArrowShots(points));
    }
}