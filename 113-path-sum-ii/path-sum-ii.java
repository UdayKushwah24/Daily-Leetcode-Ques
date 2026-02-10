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
 

import java.util.*;

class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> ll = new ArrayList<>();
        pathSum(ll, root, targetSum, 0);
        return list;
    }

    private void pathSum(List<Integer> ll, TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return;
        }

        ll.add(root.val); // current node add

        // leaf node aur sum match
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            list.add(new ArrayList<>(ll)); 
            ll.remove(ll.size() - 1); // backtrack yaha bhi
            return;
        }

        // left & right recursion
        pathSum(ll, root.left, targetSum, sum + root.val);
        pathSum(ll, root.right, targetSum, sum + root.val);

        ll.remove(ll.size() - 1); // backtrack after recursion
    }
}


/* 
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, 0, output, new ArrayList<>());
        return output;
    }

    private void dfs(TreeNode root, int targetSum, int curSum,
                     List<List<Integer>> output, List<Integer> currentPath) {
        if (root == null) return;

        // Add current node's value to sum and path
        curSum += root.val;
        currentPath.add(root.val);

        // If it's a leaf and path sum equals target, add path to result
        if (root.left == null && root.right == null && curSum == targetSum) {
            output.add(new ArrayList<>(currentPath));
        }

        // Recur for children
        dfs(root.left, targetSum, curSum, output, currentPath);
        dfs(root.right, targetSum, curSum, output, currentPath);

        // Backtrack: remove current node
        currentPath.remove(currentPath.size() - 1);
    }
}
 */


 /* 
 class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        dfs(root, targetSum, 0, ll, list);
        return list;
    }

    private void dfs(TreeNode root, int targetSum, int sum, List<Integer> ll, List<List<Integer>> list) {
        if (root == null) return;

        ll.add(root.val);

        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            list.add(new ArrayList<>(ll));
        } else {
            dfs(root.left, targetSum, sum + root.val, ll, list);
            dfs(root.right, targetSum, sum + root.val, ll, list);
        }

        // backtrack
        ll.remove(ll.size() - 1);
    }
}
  */