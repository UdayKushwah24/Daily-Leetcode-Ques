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
/* 
class Solution {
    int ans = 0;
    boolean found = false;
    public int findBottomLeftValue(TreeNode root) {
        int h = height(root);
        findBottomLeftValue(root, h, 0);
        return ans;
    }

    private void findBottomLeftValue(TreeNode root, int h, int cl) {
        if (root == null) {
            return;
        }
        if (cl == h && !found) {
             ans = root.val;
             found = true;
            return;
        } 


      
        findBottomLeftValue(root.left, h, cl + 1);
        findBottomLeftValue(root.right, h, cl + 1);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }
}
 */

class Solution {
    int ans = 0;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {

        findBottomLeftValue(root, 1);
        return ans;
    }

    private void findBottomLeftValue(TreeNode root, int cl) {
        if (root == null) {
            return;
        }
        if (cl > maxDepth) {
            ans = root.val;
            maxDepth = cl;
           
        }

        findBottomLeftValue(root.left, cl + 1);
        findBottomLeftValue(root.right, cl + 1);
    }

}