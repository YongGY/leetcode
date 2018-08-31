package a7_linkedList.basic;

import a0_common.ListNode;

/**
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * @author William
 *
 */
public class A141_LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}

		ListNode fast = head.next;
		ListNode slow = head;

		while(fast != null && fast.next != null ) {
			if(fast == slow) {
				return true;
			}

			fast = fast.next.next;
			slow = slow.next;
		}

		return false;
	}

 	public static void main(String[] args) {
 		
	}
}
