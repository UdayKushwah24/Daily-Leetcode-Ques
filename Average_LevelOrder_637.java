package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_LevelOrder_637 {
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
    // public List<Double> averageOfLevels(TreeNode root) {

    // }

    /* public static double Average(List<Integer> ll) {
        double sum = 0;
        for (int i = 0; i < ll.size(); i++) {
            sum += ll.get(i);
        }
          
        return sum / ll.size();
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> ll = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode rv = queue.remove();
                ll.add(rv.val);
                if (rv.left != null) {
                    queue.add(rv.left);
                }
                if (rv.right != null) {
                    queue.add(rv.right);
                }
            }
            list.add(Average(ll));
        }
        return list;
    } */





    
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
             double sum = 0;
            int size = queue.size();
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
            list.add(sum/size);
        }
        return list;
    }
    }
}
