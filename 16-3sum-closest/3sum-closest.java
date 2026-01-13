/*  
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];  

        for (int i = 0; i < n ; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) return target;
                else if (sum < target) left++;
                else right--;
            }
        }

        return result;
    }
}

 */

  
// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         int resultLeft = Integer.MIN_VALUE;
//         int resultRight = Integer.MAX_VALUE;
//         for (int i = 0; i < n ; i++) {
//             int left = i + 1, right = n - 1;

//             while (left < right) {
//                 int sum = nums[i] + nums[left] + nums[right];
//                 if(sum < target) {
//                     resultLeft = Math.max(sum, resultLeft);
//                 }
//                 if(sum > target) {
//                     resultRight = Math.min(sum, resultRight);
//                 }

//                 if (sum == target) return target;
//                 else if (sum < target) left++;
//                 else right--;
//             }
//         }
//         if(resultLeft - target < resultRight - target) {
//             return resultLeft;
//         } else {
//             return resultRight;
//         }
 
//     }
// }


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int resultLeft = Integer.MIN_VALUE;
        int resultRight = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) return target;

                if (sum < target) {
                    resultLeft = Math.max(resultLeft, sum);
                    left++;
                } else {
                    resultRight = Math.min(resultRight, sum);
                    right--;
                }
            }
        }

        if (resultLeft == Integer.MIN_VALUE) return resultRight;
        if (resultRight == Integer.MAX_VALUE) return resultLeft;

        if (Math.abs(target - resultLeft) <= Math.abs(target - resultRight)) {
            return resultLeft;
        } else {
            return resultRight;
        }
    }
}

