public class RemoveLinkedListElements {
 
    // Runtime: 1 ms, faster than 79.34% of Java online submissions for Remove Linked List Elements.
    // Memory Usage: 39.9 MB, less than 63.59% of Java online submissions for Remove Linked List Elements.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        
        // dumb head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        
        ListNode prev = sentinel, curr = head;
        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        
        return sentinel.next;
    }
    
}
