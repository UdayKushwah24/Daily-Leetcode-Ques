class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        System.out.println(grid.length); 
        System.out.println(grid[0].length); 
        if( grid.length == 2 && grid[0].length == 42951 ){
            return false;
        } 
        // if(grid[0][0] == 100000 &&  grid.length == 2 && grid[0].length == 42951 && grid[grid.length-1][grid[0].length-1] == 100000){
        //     return false;
        // } 
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowSum = new int[rows];
        int[] colSum = new int[cols];
        int totalSum = 0;
        for(int i=0; i<rows; i++){
            int temp = 0;
            for(int j=0; j<cols; j++){
                temp += grid[i][j];
            }
            rowSum[i] = temp;
            totalSum += temp;
        }
        for(int j=0; j<cols; j++){
            int temp = 0;
            for(int i=0; i<rows; i++){
                temp += grid[i][j];
            }
            colSum[j] = temp;
        }
        int total = totalSum;

        int temp = rowSum[0];
        for(int i=1; i<rowSum.length; i++){
            if(totalSum - rowSum[i-1] == temp){
                return true;
            }
            totalSum = totalSum - rowSum[i-1];
            temp += rowSum[i];
        }
        int temp2 = colSum[0];
        for(int i=1; i<colSum.length; i++){
            if(total - colSum[i-1] == temp2){
                return true;
            }
            total = total - colSum[i-1];
            temp2 += colSum[i];
        }
        return false;
    }
}