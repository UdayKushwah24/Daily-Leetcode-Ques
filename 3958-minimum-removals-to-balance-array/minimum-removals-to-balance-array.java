class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int j = 0;
        int maxWindow = 0;
        for (int i = 0; i < n; i++) {
            while(j < n && nums[j] <= (long) nums[i] * k) {
                j++;
            }
            maxWindow = Math.max(maxWindow, j-i);
        }
        return n - maxWindow;
    }
}


/* 

class Solution {
    public int minRemovals(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0;
        int maxLen = 1;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return n - maxLen;
    }
}

 */

/* class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=0;
        int count=0;
        for(int s=0;s<n;s++){
            if(check(nums,i,j,k)){
                j++;
            }else{
                i++;
                count++;
                j++;
            }
        }

        return count;
    }
    public static boolean check(int nums[],int i,int j,int k){
        int min = nums[i];
        int mask = min*k;
        if(nums[j]<=mask){
            return true;
        }
        return false;
    }
} */