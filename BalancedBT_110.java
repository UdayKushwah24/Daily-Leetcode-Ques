package Leetcode.Tree;

public class BalancedBT_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /* class Solution {
        // TC : O(n^2)
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            // Check the height of left and right subtrees
            int hlst = HeightTree(root.left); // height left Sub-tree
            int hrst = HeightTree(root.right); // height right Sub-tree
            // If the difference is more than 1, return false
            if (Math.abs(hlst - hrst) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
    
        private int HeightTree(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int lh = HeightTree(node.left);
            int rh = HeightTree(node.right);
            return Math.max(lh, rh) + 1;
        }
    } */
   


    // TC : O(n)
    class Solution {
        class BalancePair {
            boolean isbal = true;
            int ht = -1;
        }
            


        public boolean isBalanced(TreeNode root) {
            return isBalance(root).isbal;      
        }
        public BalancePair isBalance(TreeNode root) {
            if (root == null) {
                return new BalancePair();
            }
            BalancePair lbp = isBalance(root.left);
            BalancePair rbp = isBalance(root.right);
            BalancePair sbp = new BalancePair();
            sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
            boolean sb = Math.abs(lbp.ht - rbp.ht) <= 1;
            sbp.isbal = lbp.isbal && rbp.isbal && sb;
            return sbp;
      
        }

         
    }
}
