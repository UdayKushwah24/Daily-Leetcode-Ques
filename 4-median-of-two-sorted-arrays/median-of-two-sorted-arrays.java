class Solution {
    public int[] Merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
                k++;
            } else {
                mergedArr[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArr;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
        double ans = 0.0;
        int[] sortArray = Merge(nums1, nums2);
        int l = sortArray.length/2;
        if(sortArray.length % 2 == 0) {
            ans = (sortArray[l-1]+sortArray[l])/2.0;
        } else {
            ans = sortArray[l];
        }
        return ans;
    }
}