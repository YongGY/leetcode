package difficulty.easy200_399;
/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * 
 * Given:1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * 
 * Return: 1 --> 2 --> 3 --> 4--> 5
 */

public class E203_RemoveLinkedListElements {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
    public static ListNode removeElements(ListNode head, int val) {
    	E203_RemoveLinkedListElements.ListNode dummy = new E203_RemoveLinkedListElements().new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		
		E203_RemoveLinkedListElements e = new E203_RemoveLinkedListElements();
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
		
		System.out.println(removeElements(l1, 6) );
 	}
}
