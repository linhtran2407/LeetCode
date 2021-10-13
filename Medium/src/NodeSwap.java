import java.util.*;
/*
     * @author: Linh Tran
     * 
     * @version: Oct 12th, 2021
     */
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
