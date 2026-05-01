class Solution {




    public int maxRotateFunction(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        int f_0 = 0;
        for (int i = 0; i < n; i++) {
            f_0 += nums[i]*i;
        }
        ans = f_0;

        for (int i = 0; i < n; i++) {
            int c = f_0+sum-n*nums[n-i-1];
            ans = Math.max(ans, c);
            f_0 = c;
        }
        return ans;
    }
    /* public int maxRotateFunction(int[] nums) {
        // return  RotateFucntion(nums);
         int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            for (int j = i; j < nums.length; j++) {
                s += nums[j]*(j-i);
            }
            int ind = 0;
            for (int j = nums.length-i; j< nums.length; j++) {
                s += nums[ind++]*(j);
            }
            ans = Math.max(ans, s);
        }
        return ans;
    } */


   /*  public static void RotateArray(int[] nums) {
        int[] copyArr = new int[nums.length-1];
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = nums[i];
        }

        int first = nums[nums.length-1];
        for (int i = 1; i < nums.length;i++) {
            nums[i] = copyArr[i-1];   
        }
        nums[0] = first;
    }

    public static int RotateFucntion(int[] nums) {
        // int ans = Integer.MIN_VALUE;
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            c += i*nums[i];
        }
        // System.out.println(c);
        int ans = c;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            RotateArray(nums);
            for (int j = 0; j < nums.length; j++) {
                s += j*nums[j];
            }
            // System.out.println(s);
            ans = Math.max(ans, s);
        }
        // System.out.println();
        return ans;
    } */
}