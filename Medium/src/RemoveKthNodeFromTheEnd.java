import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
		int len = length(head);
		
		if (k < 0 || k > len){
			return;
		}
		
		int count = len-k;
		int index = 0;
		LinkedList cur = head;
		LinkedList prev = null;
		
		while (index != count){
			
			prev = cur;
			cur = cur.next;
			index++;
		}
		
		if (prev != null){
			prev.next = cur.next != null? cur.next : null;
		} else {
			// remove head
			System.out.println("ruN");
			head.value = head.next.value;
			head.next = head.next.next;
		}
		LinkedList temp = head;
		while (temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
  }
	
	private static int length(LinkedList head){
		int len = 0;
		LinkedList cur = head;
		while (cur != null){
			len++;
			cur = cur.next;
		}
		return len;
	}

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
class RemoveKthNodeFromTheEnd {
    
}
