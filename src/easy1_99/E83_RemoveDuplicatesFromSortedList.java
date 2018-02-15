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
		if(head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		while(node.next != null) {
			if(node.val == node.next.val) {
				node.next = node.next.next;
			}else {
				node = node.next;
			}
		}
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
		
 
		ListNode a = deleteDuplicates(l1);
 		while(a.next != null){
 			System.out.println(a.val);
			a = a.next;
		}
		System.out.println(a.val);

	}

}
