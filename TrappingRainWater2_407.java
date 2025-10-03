package InfinityChampionsProgram.Day6;

import java.util.*;

public class TrappingRainWater2_407 {
    public static int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.add(new int[] { heightMap[i][0], i, 0 });
            visit[i][0] = true;
            pq.add(new int[] { heightMap[i][n - 1], i, n - 1 });
            visit[i][n-1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            pq.add(new int[] { heightMap[0][i], 0, i });
            visit[0][i] = true;
            pq.add(new int[] { heightMap[m - 1][i], m - 1, i });
            visit[m-1][i] = true;
        }
        
        int water = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!pq.isEmpty()) {
          
            int h = pq.peek()[0];
            int x = pq.peek()[1];
            int y = pq.peek()[2];
            pq.poll();
            for (int[] dir : directions) {
                int i_ = x + dir[0];
                int j_ = y + dir[1];
                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && visit[i_][j_] == false) {
                    water += Math.max(h - heightMap[i_][j_], 0);
                    pq.add(new int[] { Math.max(heightMap[i_][j_], h), i_, j_ });
                    visit[i_][j_] = true;
                }
            }
 
        }
        

        return water;
    }

    public static void main(String[] args) {
        int[][] heightMap = { { 1, 4, 3, 1, 3, 2 },
                                { 3, 2, 1, 3, 2, 4 },
                                { 2, 3, 3, 2, 3, 1 } };
        System.out.println(trapRainWater(heightMap));

    }
}