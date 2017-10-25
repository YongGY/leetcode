package easy1_99;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author William
 *
 */
public class E83_RemoveDuplicatesFromSortedList {

	/**
	 * Definition for singly-linked list. 
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		
		 
		ListNode n = head.next;
		int i = head.val;
		
		while(n != null) {
			System.out.println(i + "    " + n.val);
//			if( i != n.val ) {
				i = n.val;
				n = n.next;
//			}
		}
		System.out.println(i);

		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E83_RemoveDuplicatesFromSortedList e = new E83_RemoveDuplicatesFromSortedList();
		ListNode l1= e.new ListNode(1);
		ListNode l2= e.new ListNode(1);
		ListNode l3= e.new ListNode(2);
		ListNode l4= e.new ListNode(3);
		ListNode l5= e.new ListNode(3);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
// 		while(l1.next != null){
// 			System.out.println(l1.val);
// 			l1 = l1.next;
//		}
//		System.out.println(l1.val);

		ListNode a = deleteDuplicates(l1);
// 		while(a.next != null){
// 			System.out.println(a.val);
//			a = a.next;
//		}
	}

}
