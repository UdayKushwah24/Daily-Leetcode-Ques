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
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxPathSum;
    }

    public int solve(TreeNode root) {
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        int neeche_hi_mil_gaya_answer = l + r  + root.val; // 1

        int koi_ek_acha = Math.max(l , r) + root.val; // 2

        int only_root_acha = root.val; // 3

        maxPathSum = Math.max(maxPathSum, Math.max(neeche_hi_mil_gaya_answer, Math.max(koi_ek_acha ,  only_root_acha)));

        return Math.max(koi_ek_acha,  only_root_acha);
    }
}