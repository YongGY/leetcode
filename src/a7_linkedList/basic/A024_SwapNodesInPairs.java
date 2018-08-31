package a7_linkedList.basic;

import a0_common.ListNode;

/**
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * @author William
 *
 */
public class A024_SwapNodesInPairs {

	public static  ListNode swapPairs1(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;

		while(curr.next != null && curr.next.next != null){
			ListNode first = curr.next;
			ListNode second = curr.next.next;

			first.next = second.next;
			second.next = first;
			curr.next = second;
			curr = curr.next.next;
		}

		return dummy.next;
	}


	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode curr = head.next;
		head.next = swapPairs(curr.next);
		curr.next = head;
		return curr;
	}


 	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		swapPairs1(a);
	}
}
