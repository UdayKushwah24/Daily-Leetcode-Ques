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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return check(root, root.val);
    }
    public boolean check(TreeNode node, int val) {
        if(node == null) return true;
        if(node.val != val) return false;

        boolean l = check(node.left, val);
        boolean r = check(node.right, val);
        return l & r;
    }
}