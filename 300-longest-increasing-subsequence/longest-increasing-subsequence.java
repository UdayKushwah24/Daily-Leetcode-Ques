class Solution {
    /* public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1 ;i  < n;i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    int l = dp[j];
                    dp[i] = Math.max(dp[i], l+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    } */

    public int lengthOfLIS(int[] arr) {
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int idx = BinarySearch(ll, arr[i]);
            if (idx == -1) {
                ll.add(arr[i]);
                System.out.println(ll);
            } else {
                ll.remove(idx);
                ll.add(idx, arr[i]);
            }
        }
       // System.out.println(ll);
        return ll.size();
    }

    public static int BinarySearch(List<Integer> ll, int ele) {
        int low = 0;
        int high = ll.size() - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ll.get(mid) >= ele) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}