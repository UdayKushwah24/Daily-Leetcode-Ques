// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] ans = new int[2];
//         ans[0] = findFirst(nums, target);
//         ans[1] = findLast(nums, target);
//         return ans;
//     }

//     private int findFirst(int[] nums, int target) {
//         int lo = 0, hi = nums.length - 1, first = -1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) {
//                 first = mid;
//                 hi = mid - 1;
//             } else if (nums[mid] < target) {
//                 lo = mid + 1;
//             } else {
//                 hi = mid - 1;
//             }
//         }
//         return first;
//     }

//     private int findLast(int[] nums, int target) {
//         int lo = 0, hi = nums.length - 1, last = -1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) {
//                 last = mid;
//                 lo = mid + 1;
//             } else if (nums[mid] < target) {
//                 lo = mid + 1;
//             } else {
//                 hi = mid - 1;
//             }
//         }
//         return last;
//     }
// } 



//   class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] ans = { -1, -1 };
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 if (ans[0] == -1) {
//                     ans[0] = i;
//                 }
//                 ans[1] = i;
//             }
//         }
//         return ans;
//     }
// }  
 


 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int idx = -1; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                idx = i;
                break;
            }
        }
        if ( idx == -1) {
            return ans;
        }
        ans[0] = idx;
        
        // Find the last occurrence
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans[1] = i; // set end index
                break;
            }
        }
        return ans;
    }
}   