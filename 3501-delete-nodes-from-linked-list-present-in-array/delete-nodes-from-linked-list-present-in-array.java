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
    public ListNode modifiedList(int[] num, ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < num.length; i++) {
            nums.add(num[i]);
        }
                Set<Integer> set = new HashSet<>(nums);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;

    }
}