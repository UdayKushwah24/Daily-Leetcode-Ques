/* 
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
/*
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            if (curr.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                curr.next = next;
                next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
} */


 

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node curr = head;
        while(curr != null) {
            if(curr.child != null) {
                // flatten the child node
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child= null;

                // find tail
                while(curr.next != null) {
                    curr = curr.next;
                }

                if(next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
       
    }
}