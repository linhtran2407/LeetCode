import java.util.*;

class ShiftLinkedList {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
		int len = 1;
		LinkedList tail = head;
		while (tail.next != null){
			tail = tail.next;
			len++;
		}
		
		int m = Math.abs(k) % len;
		if (m == 0){return head;}
		
		int newTailIndex = k > 0? len - m : m;
		LinkedList newTail = head;
		for (int i = 1; i < newTailIndex; i++){
			newTail = newTail.next;
		}
		
		tail.next = head;
		LinkedList newHead = newTail.next;
		newTail.next = null;
		
		return newHead;
  }
	

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
