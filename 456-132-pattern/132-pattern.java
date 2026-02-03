/* class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        for(int i =0 ;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                for(int k = j+1;k<n;k++) {
                    if(nums[i]< nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;

        // Stack<Integer> stack = new Stack<>();
        // for(int i = 0; i < nums.length ; i++) {
        //     if(stack.size() >= 2 && stack.peek() > nums[i]) {
        //         int top = stack.pop();
        //         int prev = stack.peek();
        //         if(top > prev && nums[i]> prev ) {
        //             return true;
        //         } else {
        //             stack.push(top);
        //         }

        //     } 
        //     stack.push(nums[i]);
        // }
        // return false;
    }
} */


// class Solution {
//     public boolean find132pattern(int[] nums) {
//         Stack<Integer> stack = new Stack<>();
//         for(int i = 0; i < nums.length ; i++) {
//             if(stack.size() >= 2 && stack.peek() > nums[i]) {
//                 int top = stack.pop(); // j
//                 int prev = stack.peek(); // i
//                 if(top > prev && nums[i]> prev ) {
//                     return true;
//                 } else {
//                     stack.push(top);
//                 }

//             } 
//             stack.push(nums[i]);
//         }
//         return false;
//     }
// } 


class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int nums_k = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < nums_k) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                nums_k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
