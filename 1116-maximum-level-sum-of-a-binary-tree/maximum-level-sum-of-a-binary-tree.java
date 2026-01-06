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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            level += 1;
            for (int i = 0; i < size; i++) {
                TreeNode rv = queue.remove();
                sum += rv.val;
                if (rv.left != null) {
                    queue.add(rv.left);
                }
                if (rv.right != null) {
                    queue.add(rv.right);
                }
            }
            if (sum > max) {
                ans = level;
                max = sum;
            }
        }
        return ans;
    }
}
