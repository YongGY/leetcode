package test;

import a0_common.ListNode;

public class W016_DetectAndRemoveLoopLinkedList {

	
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

	
	
	
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;    //遇到null了，说明不存在环
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;    //第一次相遇在Z点
            }
        }

        slow = head;    //slow从头开始走，
        while (slow != fast) {    //二者相遇在Y点，则退出
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
	
	
    // Driver program to test above functions 
    public static void main(String[] args) { 
//    	A016_DetectAndRemoveLoopLinkedList list = new A016_DetectAndRemoveLoopLinkedList(); 
//    	Node head = new Node(50); 
//        head.next = new Node(20); 
//        head.next.next = new Node(15); 
//        head.next.next.next = new Node(4); 
//        head.next.next.next.next = new Node(10); 
//  
//        // Creating a loop for testing  
//        head.next.next.next.next.next = head.next.next; 
//        list.detectAndRemoveLoop(head); 
//        while (head != null) { 
//            System.out.print(head.data + " "); 
//            head = head.next; 
//        }
        
//        
//        ListNode head1 = new ListNode(50); 
//        head1.next = new ListNode(20); 
//        head1.next.next = new ListNode(15); 
//        head1.next.next.next = new ListNode(4); 
//        head1.next.next.next.next = new ListNode(10); 
//  
//        // Creating a loop for testing  
//        head1.next.next.next.next.next = head1.next.next; 
//        System.out.println(detectCycle(head1));
        
        
        ListNode head1 = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
		head1.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = second;
		ListNode aaa = detectCycle(head1);
		while (head1 != null) {
			System.out.print(head1.val + " ");
			head1 = head1.next;
		}
	}
	
    
 
}
