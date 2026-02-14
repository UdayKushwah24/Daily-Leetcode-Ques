/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public void traversed(ListNode head, ArrayList<Integer> data){
        while(head != null){
            data.add(head.val);
            head = head.next;
        }
    }

    public TreeNode helper( ArrayList<Integer> data,int start,int end){
       if(start > end) return null;

       int mid = start + (end - start + 1)/2;
       TreeNode root = new TreeNode(data.get(mid));
       root.left = helper(data,start,mid-1);
       root.right = helper(data,mid+1,end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        ArrayList<Integer> data = new ArrayList<>();
        traversed(head,data);
        return helper(data,0,data.size()-1);
    }
}