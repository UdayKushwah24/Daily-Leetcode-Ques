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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        if (list1 == null) {
            dummy.next = list2;
        }
        if (list2 == null) {
            dummy.next = list1;
        }
        return temp.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode midnext = mid.next;
        mid.next = null;
        ListNode A = sortList(head);
        ListNode B = sortList(midnext);
        return mergeTwoLists(A, B);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
} */


class Solution {
    

    public ListNode mergeKLists(ListNode[] lists) {
 
       PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode rv = pq.poll();
            dummy.next = rv;
            dummy = dummy.next;
            if (rv.next != null) {
                pq.add(rv.next);
            }
        } 
        return temp.next;
    }
}