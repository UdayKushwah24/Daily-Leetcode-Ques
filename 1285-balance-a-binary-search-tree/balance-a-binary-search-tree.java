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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ll = new ArrayList<Integer>();
        inordertraversal(root, ll);
        int[] arr = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            arr[i] = ll.get(i);
        }
        return sortedArrayToBST(arr); // call

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);

    }

    public TreeNode CreateBST(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        TreeNode nn = new TreeNode();
        nn.val = arr[mid];
        nn.left = CreateBST(arr, si, mid - 1);
        nn.right = CreateBST(arr, mid + 1, ei);
        return nn;
    }

    public void inordertraversal(TreeNode root, List<Integer> ll) {
        if (root == null) {
            return;
        }
        inordertraversal(root.left, ll);
        ll.add(root.val);
        inordertraversal(root.right, ll);

    }
}