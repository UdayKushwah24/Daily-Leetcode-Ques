// class Solution {
//     public int search(int[] arr, int target) {
//         int ans = -1;
//         int start = 0;
//         int end = arr.length-1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;

//             if (arr[mid] == target) {
//                 return mid;
//             }
//             else if (arr[start] <= arr[mid]) {
//                 if (target >= arr[start] && target < arr[mid]) {
//                     end = mid - 1;
//                 } else {
//                     start = mid + 1;
//                 }
//             } 
//             else {
//                 if (target > arr[mid] && target <= arr[end]) {
//                     start = mid + 1;
//                 } else {
//                     end = mid - 1;
//                 }
//             }
//         }
//         return ans;
//     }
// }


/* class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Directly return the index if target is found
            }

            // Check if the left half is sorted
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1; // Target lies in the sorted left half
                } else {
                    start = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1; // Target lies in the sorted right half
                } else {
                    end = mid - 1; // Target is in the left half
                }
            }
        }        
        return -1; // Target not found
    }
}

 */

class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Directly return the index if target is found
            }

            // Check if the left half is sorted
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1; // Target lies in the sorted left half
                } else {
                    start = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1; // Target lies in the sorted right half
                } else {
                    end = mid - 1; // Target is in the left half
                }
            }
        }
        
        return -1; // Target not found
    }
}