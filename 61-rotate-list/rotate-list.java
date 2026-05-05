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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         
        if (head == null) return head;
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0) return head;
        ListNode start = head;
        int remain = size - k;
        ListNode ans;
        while (remain-- > 1) {
            head = head.next;
        }
        ans = head.next;
        head.next = null;
        temp.next = start;
        // System.out.println(size);

        return ans;
    }
}