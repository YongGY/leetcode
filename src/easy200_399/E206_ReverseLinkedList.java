package easy200_399;


/**
 * Reverse a singly linked list.
 */

public class E206_ReverseLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode reverseList(ListNode head)  {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
	}

	
	public static void main(String[] args) {
		
		E206_ReverseLinkedList e = new E206_ReverseLinkedList();
		ListNode l1= e.new ListNode(1);
		ListNode l2= e.new ListNode(2);
		ListNode l3= e.new ListNode(6);
		ListNode l4= e.new ListNode(3);
		ListNode l5= e.new ListNode(4);
		ListNode l6= e.new ListNode(5);
		ListNode l7= e.new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		ListNode a = reverseList(l1); 
		while(a.next != null) {
			System.out.print(a.val+"->");
			a = a.next;
		}
 	}
}
