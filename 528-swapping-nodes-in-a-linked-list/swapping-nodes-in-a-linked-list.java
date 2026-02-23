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
    public int size(ListNode temp) {
        int s = 0;
        while(temp != null) {
            s++;
            temp = temp.next;
        }
        return s;
    }
    public int getNode(ListNode temp, int k) {
        for(int i = 0; i < k;i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    public ListNode swapNodes(ListNode head, int k) {
        
        int s = size(head);
        
        int first = getNode(head, k-1);
        int second = getNode(head, s - k ); 
        ListNode temp = head;
        for(int i = 0; i < s; i++) {
            if(i == k-1) temp.val = second;
            if(i == s-k) temp.val = first;
            temp = temp.next;
        }
        return head;

    }
}