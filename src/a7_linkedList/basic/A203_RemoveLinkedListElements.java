package a7_linkedList.basic;

import a0_common.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * @author William
 *
 */
public class A203_RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return head.val == val ? head.next : head;
	}

	public static ListNode removeElements1(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null) {
			if (current.next.val == val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		System.out.println(removeElements(a,1));
	}
}
