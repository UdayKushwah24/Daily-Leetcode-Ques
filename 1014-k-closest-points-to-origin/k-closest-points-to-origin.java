class Solution {
    static class point {
        int x;
        int y;
        int dist;
        point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>(){
            @Override
            public int compare(point p1, point p2) {
                return p1.dist - p2.dist;
            }
          
    });
        for (int i = 0; i < points.length; i++) {
              int x = points[i][0];
            int y = points[i][1];
 
            int dist = x * x + y * y;
            pq.add(new point(x, y, dist));
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while (k > 0) {
            point temp = pq.poll();
            res[idx][0] = temp.x;
            res[idx][1] = temp.y;
            idx++;
            k--; 
        }
        return res;
    }
}

 