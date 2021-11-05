// Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
// Memory Usage: 36.8 MB, less than 97.13% of Java online submissions for Flatten a Multilevel Doubly Linked List.

public class FlattenAMultilevelDoublyLinkedList {
    Node tail = null;
    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        
        head.prev = tail;
        tail = head;
        
        Node nextNode = head.next;
        head.next = flatten(head.child);
        head.child = null;
        
        tail.next = flatten(nextNode);
        
        
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};