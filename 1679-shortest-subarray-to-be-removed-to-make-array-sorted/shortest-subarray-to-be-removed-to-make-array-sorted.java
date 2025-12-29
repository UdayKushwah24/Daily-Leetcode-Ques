/* class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // step 1 : find the jth pointer from right side
        int j = n - 1;
        while(j > 0 && arr[j] >= arr[j-1]) {
            j--;
        }

        if(j == 0) return 0;
        
        int i = 0;
        int res = j;

        // step 2 : start finding correct i and j and find deleted elements = j - i - 1;
        while(i < j && (i == 0 || arr[i] >= arr[i-1])) { //

            // arr[j] < arr[i]
            while(j < n && arr[i] > arr[j]) {
                j++;
            }

            // we have found correct jth element such that arr[i] <= arr[j]

            res = Math.min(res , j - i - 1);
            i++;
        }
        return res;
    }
} */

// method 2;

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left  < n-1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is already sorted
        if (left == n - 1) return 0;
        
        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Find the minimum length to remove by comparing prefix and suffix
        int result = Math.min(n - left - 1, right);
        
        // Step 4: Use two pointers to find the smallest middle part to remove
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
}