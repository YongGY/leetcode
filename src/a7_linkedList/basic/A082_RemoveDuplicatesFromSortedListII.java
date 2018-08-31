package a7_linkedList.basic;

import a0_common.ListNode;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @author William
 *
 */
public class A082_RemoveDuplicatesFromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;

		while (curr.next != null && curr.next.next != null) {
			if (curr.next.val == curr.next.next.val) {
				int dup = curr.next.val;
				while (curr.next != null && curr.next.val == dup) {
					curr.next = curr.next.next;
				}
			} else {
				curr = curr.next;
			}

		}

		return dummy.next;

	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		System.out.println(deleteDuplicates(a));
	}
}
