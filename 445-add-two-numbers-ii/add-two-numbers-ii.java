class Solution {
    public ListNode rev(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
   /*  public ListNode solve(ListNode head1, ListNode head2) {
        int car = 0;
        ListNode p = new ListNode(9);
        ListNode ans = p;
        while (head1 != null || head2 != null || car > 0) {
            int sum = car;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            int v = sum % 10;
            car = sum / 10;
            ans.next = new ListNode(v);
            ans = ans.next;
        }
        return p.next;
    } */

     public ListNode solve(ListNode l1, ListNode l2) {

        ListNode pointerRes = new ListNode(-1); // Dummy Node to act as the head anchor
        ListNode result = pointerRes; // This pointer will stay at the head to return later

        int carry = 0;

        // Loop while either list has elements remaining
        // We use || because one list might be longer than the other
        while (l1 != null || l2 != null) {

            // Calculate sum of current digits + carry from previous step
            // If a pointer is null, it contributes 0 to the sum
            int sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;

            pointerRes.next = new ListNode(sum % 10); // Create node for the ones digit of the sum
            carry = sum / 10; // Calculate carry for the next position

            // Advance pointers if possible
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            pointerRes = pointerRes.next; // Move result pointer forward
        }

        // Check if there is a remaining carry after the last digits
        if (carry > 0) {
            pointerRes.next = new ListNode(carry);
        }

        return result.next; // Return the list starting after the dummy node
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1rev = rev(l1);
        ListNode l2rev = rev(l2);
        ListNode res = solve(l1rev, l2rev);
        return rev(res);
    }
}