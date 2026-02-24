class Solution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int n) {
        if (root == null) return;

        n = n * 2 + root.val;

        if (root.left == null && root.right == null) {
            sum += n;
            return;
        }

        dfs(root.left, n);
        dfs(root.right, n);
    }
}