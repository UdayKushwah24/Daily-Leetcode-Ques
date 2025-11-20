class Solution {
    public int minimumArea(int[][] grid) {
          int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(i, bottom);
                    left = Math.min(left,j );
                    right = Math.max(right, j);
                }
            }
        }
        // System.out.print(top +" ");
        // System.out.println(bottom);
        // System.out.print(left +" ");
        // System.out.println(right);
        return (bottom-top+1)*(right-left+1);
    }
}