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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(new ArrayList<>(),root, targetSum , 0);
        return ans;
    }
    public void solve(List<Integer> ll, TreeNode root, int targetSum, int cc) {
        if(root == null) return;
        if(root.left == null && root.right == null ) {
            if(targetSum == cc + root.val) {
                ll.add(root.val);
                ans.add(new ArrayList<>(ll));
                ll.remove(ll.size()- 1);
                return;
            }
        }

        ll.add(root.val);
        solve(ll, root.left, targetSum, cc + root.val);
        solve(ll, root.right, targetSum, cc + root.val);
        ll.remove(ll.size()-1);
    }
}