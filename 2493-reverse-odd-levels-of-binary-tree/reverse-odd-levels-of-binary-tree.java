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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean odd = false;
        while (!q.isEmpty()) {
            int s = q.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                list.add(node);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if(odd) {
                int l = 0; 
                int r = list.size()-1;
                while(l < r) {
                    int temp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = temp;
                    l++;
                    r--;
                }
            }
            odd = !odd;
        }

        return root;
    }
}