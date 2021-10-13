import java.util.*;

public class ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        if (head == null){
                return null;
            }
            
            LinkedList prev = null;
            LinkedList cur = head;
            while (cur != null){
                LinkedList nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }
        return prev;
      }
    
    static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
        this.value = value;
    }
    }
}
