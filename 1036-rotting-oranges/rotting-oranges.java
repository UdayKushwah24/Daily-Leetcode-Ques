class Solution {
    public int orangesRotting(int[][] grid) {
        return rottenOranges(grid);
    }
 static class coordinates {

        int x;
        int y;

        public coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int rottenOranges(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        Queue<coordinates> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new coordinates(i, j));
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                coordinates c = queue.poll();
                int x = c.x;
                int y = c.y;
                CheckAndPutNeighbours(grid, queue, x, y, rows, cols);
            }
            if(!queue.isEmpty()) minutes++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }

    private static void CheckAndPutNeighbours(int[][] grid, Queue<coordinates> queue, int i, int j, int rows, int cols) {
        if (i > 0 && grid[i - 1][j] == 1) {
            queue.add(new coordinates(i - 1, j));
            grid[i - 1][j] = 2;
        }
        if (i < rows-1 && grid[i + 1][j] == 1) {
            queue.add(new coordinates(i + 1, j));
            grid[i + 1][j] = 2;
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            queue.add(new coordinates(i, j - 1));
            grid[i][j - 1] = 2;
        }
        if (j < cols-1 && grid[i][j + 1] == 1) {
            queue.add(new coordinates(i, j + 1));
            grid[i][j + 1] = 2;
        }

    }
}
