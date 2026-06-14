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
    public int size(ListNode cur) {
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int len = size(temp);
        temp = head;
        int[] arr  = new int[len];
        int idx = 0 ;
        while(temp != null) {
            arr[idx] = temp.val;
            temp = temp.next;
            idx++;
        }
        int ans = Integer.MIN_VALUE;
        int last = len-1;
        for(int i = 0;i < len/2  ; i++) {
            ans = Math.max(ans, arr[i]+arr[last]);
            last--;
        }  
        return ans;       
    }
} */


class Solution {
    public int pairSum(ListNode head) {
        ListNode temp = head;
        List<Integer> ll = new ArrayList<>();
        while(temp != null) {
            ll.add(temp.val);
            temp = temp.next;
        }       
        int ans = Integer.MIN_VALUE;
        int last = ll.size()-1;
        for(int i = 0;i < ll.size()/2  ; i++) {
            ans = Math.max(ans, ll.get(i)+ll.get(last));
            last--;
        }  
        return ans;       
    }
}