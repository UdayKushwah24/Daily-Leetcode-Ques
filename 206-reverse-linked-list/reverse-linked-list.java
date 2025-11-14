/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
       public ListNode reverseList(ListNode head) {
       ListNode curr = head;
       ListNode prev = null;
       while(curr != null) {
       ListNode ahead = curr.next;
       curr.next = prev;
       prev = curr;
       curr = ahead;
       }
       return prev;
       }
    

    
    //    public ListNode reverseList(ListNode head) {
    //         ListNode first = head;
    //         ListNode prev = null;
    //         ListNode curr = head;
    //         while(curr.next != null){
    //             LisNode temp = head;
    //             curr.next = prev;
    //             prev = curr.next;
    //             curr = temp.next;
    //         }
    //    }
    

    // Using Recursion :
    /* public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }.
        ListNode temp = reverse(curr.next, curr);
        curr.next = prev;
        
        return temp;
    } */
}