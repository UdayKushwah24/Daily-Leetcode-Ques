/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;

    public void sum(TreeNode root, boolean isLeftNode) {
        if(root == null) return ;
        if (root.left == null && root.right == null && isLeftNode) {
            ans += root.val;
            return;
        }
        sum(root.left, true);
        sum(root.right , false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum(root, false);
        return ans;
    }
}