class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans[] = new int[n];
        int i = (n+1)/2 - 1;
        int j = n-1;
        for (int k = 0; k < n;) {
            if (k < n) {
                ans[k] = nums[i--];
            }
            k++;
            if (k < n) {
                ans[k] = nums[j--];
            }
            k++;
        }
        for (int k = 0; k < n; k++) {
            nums[k] = ans[k];
        }
    }
}