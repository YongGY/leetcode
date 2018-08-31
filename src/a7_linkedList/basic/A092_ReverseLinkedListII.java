package a7_linkedList.basic;

import a0_common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author William
 *
 */
public class A092_ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m >= n) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		ListNode pre = head; // pre node

		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		ListNode nodeA = pre.next;
		ListNode nodeB = pre.next.next;

		for (int i = 0; i < n - m; i++) {
			nodeA.next = nodeB.next;
			nodeB.next = pre.next;
			pre.next = nodeB;
			nodeB = nodeA.next;
		}

		return dummy.next;

	}
    
 	public static void main(String[] args) {
 		
	}
}
