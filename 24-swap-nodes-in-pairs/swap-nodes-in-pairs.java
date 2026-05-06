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
    public ListNode swapPairs(ListNode head) {
        // if(head == null) return head;
        // if(head.next == null) return head;
        // ListNode ans = null;
        // while(head.next != null) {
        //     ans = head.next;
        //     ans.next = head;
        //     head = head.next.next;
        //     ans = ans.next;
        // }
        // return ans;
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        ListNode ans = head.next;
        ListNode pr = null;

        while (head != null && head.next != null) {

            ListNode nx = head.next.next;
            ListNode sc = head.next;

            sc.next = head;
            head.next = nx;

            if (pr != null) {
                pr.next = sc;
            }

            pr = head;
            head = nx;
        }

        return ans;
    }

    // public ListNode swapPairs(ListNode head) {
    //     if (head == null)
    //         return head;
    //     if (head.next == null)
    //         return head;
    //     List<Integer> ll = new ArrayList<>();
    //     while (head.next != null) {
    //         ll.add(head.val);
    //         head = head.next;
    //     }
    //     ll.add(head.val);
    //     int n = ll.size();
    //     int[] arr = new int[n];
    //     // for(int i = 0; i < n; i+=2) {
    //     //     if(i < n) {
    //     //         arr[i] = ll.get(i+1);
    //     //         arr[i+1] = ll.get(i);
    //     //     }
    //     // }
    //     for (int i = 0; i < n; i += 2) {
    //         if (i + 1 < n) { // ✅ FIX
    //             arr[i] = ll.get(i + 1);
    //             arr[i + 1] = ll.get(i);
    //         } else {
    //             arr[i] = ll.get(i); // ✅ last element same rahega
    //         }
    //     }
    //     // for(int i = 0; i < n ; i++) {
    //     //     System.out.print(arr[i] + " ");
    //     // }
    //     // System.out.println();
    //     // System.out.println(ll);
    //     ListNode temp = new ListNode(arr[0]);
    //     ListNode ans = temp;
    //     for (int i = 1; i < n; i++) {
    //         ans.next = new ListNode(arr[i]);
    //         ans = ans.next;
    //     }
    //     return temp;
    // }
}