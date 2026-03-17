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
/* class Solution {
     public void Inorder(TreeNode root, List<Integer> list) {

            if (root == null) {
                return ;
            }
            Inorder(root.left, list);
            list.add(root.val);
            Inorder(root.right, list);
        }

        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Inorder(root, list);
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i-1)>=(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
} */

class Solution {
     
        class BSTPair {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            boolean isbst = true;
        }

        public BSTPair validBST(TreeNode root) {
            if (root == null) {
                return new BSTPair();
            }
            BSTPair lbp = validBST(root.left);
            BSTPair rbp = validBST(root.right);
            BSTPair sbp = new BSTPair();
            sbp.max = Math.max(rbp.max, Math.max(lbp.max, root.val));
            sbp.min = Math.min(rbp.min, Math.min(lbp.min, root.val));
            sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.val && root.val < rbp.min;
            return sbp;                                  
        }
        public boolean isValidBST(TreeNode root) {
            return validBST(root).isbst;
        } 
 
}