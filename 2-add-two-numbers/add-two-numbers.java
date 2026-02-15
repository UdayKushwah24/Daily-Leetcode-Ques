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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        ListNode pointerRes = new ListNode(-1);             // Dummy Node to act as the head anchor
        ListNode result = pointerRes;                       // This pointer will stay at the head to return later

        int carry = 0;
        
        // Loop while either list has elements remaining
        // We use || because one list might be longer than the other
        while(l1 != null || l2 != null){
            
            // Calculate sum of current digits + carry from previous step
            // If a pointer is null, it contributes 0 to the sum
            int sum = ((l1 != null)? l1.val : 0) +  ((l2 != null)? l2.val : 0) + carry;
            
            pointerRes.next = new ListNode(sum % 10);       // Create node for the ones digit of the sum
            carry = sum / 10;                               // Calculate carry for the next position

            // Advance pointers if possible
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
            pointerRes = pointerRes.next;                   // Move result pointer forward
        }
        
        // Check if there is a remaining carry after the last digits
        if(carry > 0){
            pointerRes.next = new ListNode(carry);
        }
        
        return result.next;         // Return the list starting after the dummy node
    }
}