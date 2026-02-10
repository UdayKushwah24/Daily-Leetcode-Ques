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
 *//* 
class Solution {
    TreeSet<Integer> ll = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        preOrder(root);
        if(ll.size() <= 1) return -1;
        ll.pollFirst();
        return ll.first();
    }

    public void preOrder(TreeNode root) {
        if(root == null) return ;

        ll.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
} */




class Solution {
    List<Integer> ll = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        preOrder(root);
        if(ll.size() <= 1) return -1;
        Collections.sort(ll);
        return ll.get(1);
    }

    public void preOrder(TreeNode root) {
        if(root == null) return ;
        if(!ll.contains(root.val))ll.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}