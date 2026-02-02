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
/* class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int n = size(head);
        if(n == 1 || n == 0) return null;
        if(n%2==0) n = n+1;
        int middle = n/2;
        ListNode temp = head;
        int c = 0;
        while(temp != null) {
             c++;
            if(c == middle) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public int size(ListNode head ) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
} */




class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

     
}