package Leetcode.Tree;

public class BinaryTreeCameras_968 {
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

    class Solution {
        int camera = 0;
        public int minCameraCover(TreeNode root) {
            int c = minCamera(root);
            if (c == -1) {
                camera++;
            }
            return camera;
        }

        public int minCamera(TreeNode root) {
            
            if (root == null) {
                return 0;
            }
            int left = minCamera(root.left);
            int right = minCamera(root.right);
            if (left == -1 || right == -1) { // -1 -> iss node per camera ki need hai
                camera++;
                return 1; // camera setup kiya hai iss node per
            }
            if (left == 1 || right == 1) { // inme se koi ek ke pass ya dono ke pass camera hai or ek ke pass camera hai dusra wala covered hai
                return 0; // iska mtlb mai covered hu
            } else {
                return -1; // need a camera
            }
        }

    }
}
