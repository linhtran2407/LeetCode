import java.util.*;

class NodeSwap {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList nodeSwap(LinkedList head) {
    if (head == null || head.next == null){
			return head; // no swap needed
		}
		
		// swap
		LinkedList nextNode = head.next;
		LinkedList nextNextNode = head.next.next;
		nextNode.next = head;
		head.next = nodeSwap(nextNextNode);
			
    return nextNode;
  }
}
