class Solution {
    public boolean canPartitionGrid(int[][] grid) {
       
        int rows = grid.length;
        int cols = grid[0].length;
        //  if( rows  == 2 && cols == 42951 ){
        //     return false;
        // } 
        long[] rowSum = new long[rows];
        long[] colSum = new long[cols];
        long totalSum = 0;
        for(int i=0; i<rows; i++){
            long temp = 0;
            for(int j=0; j<cols; j++){
                temp += grid[i][j];
            }
            rowSum[i] = temp;
            totalSum += temp;
        }
        for(int j=0; j<cols; j++){
            long temp = 0;
            for(int i=0; i<rows; i++){
                temp += grid[i][j];
            }
            colSum[j] = temp;
        }
        long total = totalSum;

        long temp = rowSum[0];
        for(int i=1; i<rowSum.length; i++){
            if(totalSum - rowSum[i-1] == temp){
                return true;
            }
            totalSum = totalSum - rowSum[i-1];
            temp += rowSum[i];
        }
        long temp2 = colSum[0];
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