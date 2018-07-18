package difficulty.medium1_99;

import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author William
 *
 */
public class M24_SwapNodesInPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node = dummy;

		while (head != null && head.next != null) {
			node.next = head.next;
			head.next = node.next.next;
			node.next.next = head;
			node = head;
			head = head.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
