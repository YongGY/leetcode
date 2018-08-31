package a7_linkedList.basic;

import a0_common.ListNode;

/**
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * @author William
 *
 */
public class A206_ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode res = null;
		while(head != null){
			ListNode tmp = head.next;
			head.next = res;
			res = head;
			head = tmp;
		}
		return res;
	}

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		//get second node
		ListNode second = head.next;
		//set first's next to be null
		head.next = null;

		ListNode rest = reverseList1(second);
		second.next = head;

		return rest;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		System.out.println(reverseList(a));
	}
}
