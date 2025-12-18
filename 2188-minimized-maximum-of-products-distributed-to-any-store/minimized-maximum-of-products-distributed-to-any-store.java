class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        int ans = Integer.MIN_VALUE;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(possible(quantities, n, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean possible(int[ ] arr, int threshold, int mid) {
        int div = 0;
        for(int i = 0;  i < arr.length; i++) {
            div += Math.ceil(arr[i]*1.0/mid);
        }
        return div <= threshold;
    }
}