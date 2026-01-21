/* class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        if(m % 2 == 0 && n % 2 == 0) return 0;
        if (m % 2 == 1) {
            for (int i = 0; i < n; i++) {
                ans ^= nums2[i];
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < m; i++) {
                ans ^= nums1[i];
            }
        }
        if (m % 2 == 1 && n % 2 == 1) {
            for (int i = 0; i < m; i++) {
                ans ^= nums1[i];
            }
            for (int i = 0; i < n; i++) {
                ans ^= nums2[i];
            }
        }
        return ans;

    }
} */

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        if (m % 2 == 0 && n % 2 == 0) {
            return 0;
        }
        int xor1 = BitwiseXOR(nums1);
        int xor2 = BitwiseXOR(nums2);
        if(m % 2 == 1 && n % 2 == 1) {
            return xor1 ^ xor2;
        } else if(m % 2 == 1) {
            return xor2;
        } else {
            return xor1;
        }
    

    }

    public int BitwiseXOR(int arr[]) {
        int xor = 0;
        for(int a : arr) {
             xor ^= a;  
        }
        return xor;
    }
}