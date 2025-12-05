/* class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int m = matrix.length;
        int n = matrix[0].length;

        // Apply binary search on the matrix considered as a 1D array
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n]; // Get the element at mid position in the matrix

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
} */



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] < target){
                m++;
            } else {
                n--;
            }
        }        
        return false;
    }
}