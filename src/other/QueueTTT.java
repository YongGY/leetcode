package other;

import other.Queue.Node;

/**
 * 
 * @author William
 *
 */
public class QueueTTT {

	class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	Node head;
	Node curr;
	
	public void push(int val) {
		if(head == null) {
			head = new Node(val);
			curr = head;
		}else {
			curr.next = new Node(val);
			curr = curr.next;
		}
	}
	
	public int pop() {
		if(head == null) {
			
		}
		Node node = head;
		head = head.next;
		return node.val;
	}

}
