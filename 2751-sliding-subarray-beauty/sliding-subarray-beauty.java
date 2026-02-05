class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int n = nums.length;
        int[] a = new int[101];
        int[] res = new int[n - k + 1];

        // first window
        for (int j = 0; j < k; j++) {
            a[nums[j] + 50]++;
        }

        for (int i = 0; i <= n - k; i++) {

            int c = 0;

            for (int p = 0; p < 101; p++) {
                c += a[p];
                if (c >= x) {
                    int val = p - 50;
                    res[i] = val < 0 ? val : 0;
                    break;
                }
            }

            // slide window
            if (i + k < n) {
                a[nums[i] + 50]--;        // remove left
                a[nums[i + k] + 50]++;    // add right
            }
        }
        return res;
    }
}
 /* 

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int a[] = new int[101];
        int res[] = new int[n - k + 1];
        for (int j = 0; j < k; j++) {
            a[nums[j] + 50]++;
        }
        for (int i = 0; i < n - k; i++) {
            
            int c = 0;
            for(int p = 0; p < 101; p++) {
                if(a[p] != 0) {
                    c+=a[p];
                }
                if(c >= x){
                    int val = (p - 50);
                    if(val < 0) res[i] = val;
                    else res[i] = 0;

                    a[p] = a[p] -1;
                    break;
                }
            }
            a[nums[i+k] + 50]++;
        }
        return res;
    }
} */