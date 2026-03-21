class NumArray {

    
    int[] segmentTree ;
    int n;
    public NumArray(int[] nums) {
         n = nums.length;
        segmentTree = new int[4*n ];
        // segmentTree = new int[2*n - 1];
        buildTree(nums, 0, 0 ,n-1);
    }
    public void buildTree(int[] nums, int i, int l, int r) {
        if(l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid =  l + (r - l) / 2;
        buildTree(nums, 2*i+1, l, mid);
        buildTree(nums, 2*i+2,  mid+1, r);
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i + 2];
    }
    
     
    public int sumRange(int left, int right) {
        return sum(0, 0, n-1, left, right);
    }
    public int sum(int i, int l, int r, int s, int e) {
        if(r < s || l > e) return 0;
        if(s <= l && r <= e ) return segmentTree[i];
        int mid =  l + (r - l) / 2;
        int left = sum(2*i+1, l, mid, s, e);
        int right = sum(2*i+2, mid+1, r, s, e);

        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */