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
// galat hai
/* class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        TreeNode temp = root;
        for (int i = 0; i < n; i++) {
             find(temp, queries[i]);
             ans[i] = height(temp);
             temp = root;
        }
        return ans;
    }

    public void find(TreeNode node, int q) {
        if(node == null) {
            return;
        }
        if(node.val == q) {
            node.left = null;
            node.right = null;
            return;
        }
        find(node.left, q);
        find(node.right, q);
    }
    public int height(TreeNode node) {
        if (node == null)
            return -1;
        int lh =  height(node.left);
        int rh = height(node.right);
        return  Math.max(lh, rh) + 1;
    }
}  
 */

   

// TLE
/* 
class Solution {

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = height(root, queries[i]);
        }

        return ans;
    }

    public int height(TreeNode node, int block) {
        if (node == null || node.val == block)
            return -1;

        int lh = height(node.left, block);
        int rh = height(node.right, block);

        return Math.max(lh, rh) + 1;
    }
}
 */




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
    private int[] level = new int[1000001];
    private int[] height = new int[1000001];
    private int[] levelMaxHt = new int[1000001];
    private int[] levelSecondMaxHt = new int[1000001];
    private int findMaxHeight(TreeNode root, int l) {
        if (root == null) return 0;
        level[root.val] = l;
        height[root.val] = Math.max(findMaxHeight(root.left, l + 1), findMaxHeight(root.right, l+1)) + 1;

        if (levelMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.val];

        } else if (levelSecondMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = height[root.val];
        }
        return height[root.val];
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        findMaxHeight(root, 0);
        int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int L = level[node];
            int tempResult = L + (levelMaxHt[L] == height[node] ? levelSecondMaxHt[L] : levelMaxHt[L]) - 1;
            result[i] = tempResult;
        }
        return result;
    }
}