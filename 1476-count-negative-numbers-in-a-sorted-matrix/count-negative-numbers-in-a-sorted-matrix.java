/* class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int lo = 0;
            int firstNegativeIndex = n;  // Default to n if no negative number is found
            int hi = n-1;
            while (lo <= hi) {
                int mid = hi+(lo-hi)/2;
                if(grid[i][mid] < 0) {
                    firstNegativeIndex = mid;
                    hi = mid - 1;    // Look for earlier negatives on the left side
                } else {
                    lo = mid+1;      // Look for negatives on the right side
                }
            }
            
            count += (n-firstNegativeIndex);
            
        }
        return count;
    }
} */





class Solution {
    
    public   int countNegatives(int[][] grid) {

        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            int arr[] = grid[i];
            int idx = firstNegative(arr);
            c += arr.length-idx;
        }
        return c;
    }

    
    private   int firstNegative(int[] arr) {
        int l = 0, h = arr.length-1;
        int idx = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] < 0) {
                idx = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (idx == -1) {
            return arr.length;
        }
        return idx;
    }

}