package a7_linkedList.basic;

import a0_common.ListNode;

/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * @author William
 *
 */
public class A083_RemoveDuplicatesFromSortedList {

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode curr = head;

		while(curr != null && curr.next != null){
			if(curr.val == curr.next.val){
				curr.next = curr.next.next;
			}else {
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		a.next = new ListNode(0);
		a.next.next = new ListNode(0);
		a.next.next.next = new ListNode(0);
		a.next.next.next.next = new ListNode(0);
		a.next.next.next.next.next = new ListNode(0);
		System.out.println(deleteDuplicates(a));
	}
}
