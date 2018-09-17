package questions.xx;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 *
 *
 * Function to find whether a given number is a power of 4.
 *
 * @author William
 *
 */
public class A016_DetectAndRemoveLoopLinkedList {

	
	/**
	 * Detect and Remove Loop in a Linked List
	 *
	 */
	
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function that detects loop in the list
	void detectAndRemoveLoop(Node node) {

		// If list is empty or has only one node
		// without loop
		if (node == null || node.next == null)
			return;

		Node slow = node, fast = node;

		// Move slow and fast 1 and 2 steps
		// ahead respectively.
		slow = slow.next;
		fast = fast.next.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;

			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = node;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */
		}
	}

    // Driver program to test above functions 
    public static void main(String[] args) { 
    	A016_DetectAndRemoveLoopLinkedList list = new A016_DetectAndRemoveLoopLinkedList(); 
    	Node head = new Node(50); 
        head.next = new Node(20); 
        head.next.next = new Node(15); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing  
        head.next.next.next.next.next = head.next.next; 
        list.detectAndRemoveLoop(head); 
        while (head != null) { 
            System.out.print(head.data + " "); 
            head = head.next; 
        }
     } 
	
}
