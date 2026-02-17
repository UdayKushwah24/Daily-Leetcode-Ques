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
    public int size(ListNode head) {
        int s = 0;
        while (head != null) {
            head = head.next;
            s++;
        }
        return s;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int n = size(head);
        int[] arr = new int[n];

        temp = head;
        for (int i = 0; i < n; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        int l = left - 1;
        int r = right - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        for (int i = 0; i < arr.length; i++) {
            ListNode nn = new ListNode(arr[i]);
            ans.next = nn;
            ans = nn;
        }
        return res.next;
    }
}