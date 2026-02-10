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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
//     }
// }
/* 
class Solution {

    public List<Integer> Reverse(List<Integer> list) {
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ll.add(list.get(list.size() - 1 - i));
        }
        return ll;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list; 

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;  

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode rv = queue.remove();
                level.add(rv.val);

                if (rv.left != null) queue.add(rv.left);
                if (rv.right != null) queue.add(rv.right);
            }

            if (flag)
                list.add(level);
            else
                list.add(Reverse(level));  

            flag = !flag;   
        }

        return list;
    }
}
 */


 class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;

    }
}