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
    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode node) {
        if(node.val == 1) return true;
        if(node.val == 0) return false;

        boolean l = helper(node.left);
        boolean r = helper(node.right);

        if(node.val == 2) return (l | r);
        else return (l & r);
    }
}