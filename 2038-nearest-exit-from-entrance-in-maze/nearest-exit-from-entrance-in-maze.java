class Solution {
   
   
    public static int nearestExit(char[][] maze, int[] entrance) {
                int rows = maze.length;
        int cols = maze[0].length;
        int x = entrance[0];
        int y = entrance[1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        maze[x][y] = '+'; // mark entrance visited
        int step = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];

                // exit condition
                if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1)
                        && !(i == x && j == y)) {
                    return step;
                }

                // explore neighbours
                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && maze[ni][nj] == '.') {
                        queue.add(new int[]{ni, nj});
                        maze[ni][nj] = '+'; // mark visited immediately
                    }
                }
            }
            step++;
        }

        return -1;
        

    }
}