/* class Solution {

    public int maxSumMinProduct(int[] n) {
        Stack<Integer> st = new Stack<>();
        long dp[] = new long[n.length + 1], res = 0;

        for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];

        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int) (res % 1000000007);

    }
} */


class Solution {

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long mod = 1000000007;
        long[] preSum = new long[n+1];
        for(int i = 0; i < n;i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && (nums[stack.peek()] >= nums[i])) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = n-1; i >=0; i--) {
            while(!stack.isEmpty() && (nums[stack.peek()] > nums[i])) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long ans = 0;
        for(int i = 0; i < n;i++) {
            int l = left[i] + 1;
            int r = right[i] -1;

            long subSum = preSum[r+1] - preSum[l];
            long minPro = nums[i] * subSum;
            ans = Math.max(ans, minPro);

        }
        return (int)(ans % mod);
    }
}