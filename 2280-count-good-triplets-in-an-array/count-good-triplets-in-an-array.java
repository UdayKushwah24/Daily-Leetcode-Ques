class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
          int n = nums1.length;
        segmentTree = new int[4 * n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        updateSegmentTree(0, 0, n-1, map.get(nums1[0]));
        long ans = 0;
        for (int i = 1; i < n; i++) {
            int idx = map.get(nums1[i]);
            long leftCommonCount = query(0, 0, n - 1, 0, idx);
            long leftUnCommonCount = i - leftCommonCount;
            long elementsAfterIdxNums2 = (n - 1 - idx);
            long rightCommonCount = elementsAfterIdxNums2 - leftUnCommonCount;
            ans += (leftCommonCount * rightCommonCount);
            updateSegmentTree(0, 0, n-1, idx);
        }
        return ans;
    }

    
    static int segmentTree[];

    public static void updateSegmentTree(int i, int l, int r, int idx) {
        if (l == r) {
            segmentTree[i] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateSegmentTree(2 * i + 1, l, mid, idx);
        } else {
            updateSegmentTree(2 * i + 2, mid + 1, r, idx);
        }
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public static int query(int i, int l, int r, int qs, int qe) {
        if (r < qs || l > qe) {
            return 0;
        }
        if (qs <= l && r <= qe) {
            return segmentTree[i];
        }
        int mid = l + (r - l) / 2;
        int left = query(2 * i + 1, l, mid, qs, qe);
        int right = query(2 * i + 2, mid + 1, r, qs, qe);
        return left + right;
    }
 
}