class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
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
        if(totalSum % 2 == 1) return false;

        long target = totalSum /  2;
        long csum = 0;
        for(int i = 0; i < rows; i++) {
            if(csum == target) return true;
            csum += rowSum[i];
        }
        csum = 0;
        for(int i = 0; i < cols; i++) {
            if(csum == target) return true;
            csum += colSum[i];

        }
        return false;
        
    }
}


// class Solution {
//     public boolean canPartitionGrid(int[][] grid) {
       
//         int rows = grid.length;
//         int cols = grid[0].length;
//         long[] rowSum = new long[rows];
//         long[] colSum = new long[cols];
//         long totalSum = 0;
//         for(int i=0; i<rows; i++){
//             for(int j=0; j<cols; j++){
//                 rowSum[i] += grid[i][j];
//                 colSum[j] += grid[i][j];
//                 totalSum += grid[i][j];
//             }           
//         }
//         long target = totalSum/2;
//         long csum = 0;
//         for(int i = 0; i < rows; i++) {
//             if(csum == target) return true;
//             csum += rowSum[i];
//         }
//         csum = 0;
//         for(int i = 0; i < rows; i++) {
//             if(csum == target) return true;
//             csum += rowSum[i];
//         }
        
//         return false;
//     }
// }