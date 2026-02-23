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
   public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode o = odd;
        ListNode e = even;
        boolean flag = true;
        while(head != null ) {
            if(flag) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            flag = !flag;
            head = head.next;
        }
        even.next = null;
        odd.next = e.next;
        return o.next;
   }
}
/* 
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(); 
        ListNode temp = odd;
        ListNode even = head;
        ListNode ans = even;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            even.next = curr.next.next;
            curr = curr.next.next;
        }
        curr = head.next;
        while (curr != null && curr.next != null) {
            odd.next = curr.next.next;
            curr = curr.next.next;
        }
        even.next = temp.next;
        return ans.next;
    }
} */

/* class Solution {
   public ListNode oddEvenList(ListNode head) {

       if (head == null || head.next == null)
           return head;

       ListNode oddDummy = new ListNode(0);
       ListNode evenDummy = new ListNode(0);

       ListNode odd = oddDummy;
       ListNode even = evenDummy;

       boolean flag = true;   // true → odd position

       while (head != null) {

           if (flag) {
               odd.next = head;
               odd = odd.next;
           } else {
               even.next = head;
               even = even.next;
           }

           head = head.next;
           flag = !flag;
       }

       // Important: terminate even list
       even.next = null;

       // Connect odd list to even list
       odd.next = evenDummy.next;

       return oddDummy.next;
   }
} */