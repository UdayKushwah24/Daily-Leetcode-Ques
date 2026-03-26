class Solution {
   static int[] segmentTree;

    public static void buildMaxIndexTree(int[] heights, int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = l;
            return;
        }
        int mid = l + (r - l) / 2;
        buildMaxIndexTree(heights, 2 * i + 1, l, mid);
        buildMaxIndexTree(heights, 2 * i + 2, mid + 1, r);
        int leftMaxIndex = segmentTree[2 * i + 1];
        int rightMaxIndex = segmentTree[2 * i + 2];
        if (heights[leftMaxIndex] >= heights[rightMaxIndex]) {
            segmentTree[i] = leftMaxIndex;
        } else {
            segmentTree[i] = rightMaxIndex;
        }
    }

    public static int MaxIndexInRangeQuery(int[] arr, int i, int l, int r, int start, int end) {
        // No overlap
        if (r < start || l > end) {
            return -1;
        }

        // Complete overlap
        if (start <= l && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;

        int l_max_idx = MaxIndexInRangeQuery(arr, 2 * i + 1, l, mid, start, end);
        int r_max_idx = MaxIndexInRangeQuery(arr, 2 * i + 2, mid + 1, r, start, end);
        if (l_max_idx == -1) {
            return r_max_idx;
        }
        if (r_max_idx == -1) {
            return l_max_idx;
        }
        if (arr[l_max_idx] >= arr[r_max_idx]) {
            return l_max_idx;
        } else {
            return r_max_idx;
        }
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int size = queries.length;
        int ans[] = new int[size];
        Arrays.fill(ans, -1);
        segmentTree = new int[4 * n];
        buildMaxIndexTree(heights, 0, 0, n - 1);
        int idx = 0;
        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            int maxIdx = Math.max(start, end);
            int minIdx = Math.min(start, end);
            if (start == end) {
                ans[idx] = start;
            } else if (heights[maxIdx] > heights[minIdx]) {
                ans[idx] = maxIdx;
            } else {
                int l = maxIdx + 1;
                int r = n - 1;
                int leftMostIdx = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    int leftMaxIdx = MaxIndexInRangeQuery(heights, 0, 0, n - 1, l, mid);
                    if(heights[leftMaxIdx] > Math.max(heights[maxIdx], heights[minIdx])){
                        leftMostIdx = leftMaxIdx;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                ans[idx] = leftMostIdx;
            }
            idx++;
        }
        return ans;
    }

}