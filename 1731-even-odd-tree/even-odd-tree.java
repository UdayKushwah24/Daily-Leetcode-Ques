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
    public boolean isEvenOddTree(TreeNode root) {
        return LevelOrderTraversal(root);
    }

    public boolean CheckIncreasing(List<Integer> ll) {
        boolean flag = true;

        if (ll.get(0) % 2 == 0) {
            flag = false;
        }
        for (int i = 1; i < ll.size(); i++) {
            if (ll.get(i - 1) >= ll.get(i) || ll.get(i) % 2 == 0) {
                flag = false;
                break;
            }

        }
        return flag;
    }

    public boolean CheckDecreasing(List<Integer> ll) {
        boolean flag = true;

        if (ll.get(0) % 2 != 0) {
            flag = false;
        }
        for (int i = 1; i < ll.size(); i++) {
            if (ll.get(i - 1) <= ll.get(i) || ll.get(i) % 2 != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean LevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

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
            if (flag && !CheckIncreasing(ll)) {
                return false;
            }
            if (!flag && !CheckDecreasing(ll)) {
                return false;
            }
            flag = !flag;
        }
        return true;
    }
} */


class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        return LevelOrderTraversal(root);
    }

    public boolean LevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEvenLevel = true;

        while (!queue.isEmpty()) { 
            int size = queue.size();
            int preVal = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode rv = queue.remove();
                if (isEvenLevel) {
                    if (preVal >= rv.val || rv.val % 2 == 0) {
                        return false;
                    }
                    preVal = rv.val;
                } else {
                    if (preVal <= rv.val || rv.val % 2 == 1) {
                        return false;
                    }
                    preVal = rv.val;
                }
              
                if (rv.left != null) {
                    queue.add(rv.left);
                }
                if (rv.right != null) {
                    queue.add(rv.right);
                }
            }

            isEvenLevel = !isEvenLevel;
        }
        return true;
    }
}
