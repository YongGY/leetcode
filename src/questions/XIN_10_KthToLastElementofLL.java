package questions;

import a0_common.ListNode;

public class XIN_10_KthToLastElementofLL {

	public int kthByRecursion(ListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int i = kthByRecursion(head.next, k) + 1;
		if (i == k) {
			
			System.out.println(head.val + "-------");
		}
		return i;
	}

	public int kthByIteration(ListNode head, int k) {
		if (head == null) {
			return 0;
		}
		ListNode curr = head;
		while (k > 0) {
			curr = curr.next;
			k--;
		}
		ListNode sec = head;
		while (curr != null) {
			curr = curr.next;
			sec = sec.next;
		}
		return sec.val;
	}

	public static void main(String args[]) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(8);
		n.next.next.next = new ListNode(3);
		n.next.next.next.next = new ListNode(7);
		n.next.next.next.next.next = new ListNode(0);
		n.next.next.next.next.next.next = new ListNode(4);
		XIN_10_KthToLastElementofLL rm = new XIN_10_KthToLastElementofLL();
		System.out.println(n);

		System.out.println(rm.kthByRecursion(n, 2));
		System.out.println(rm.kthByIteration(n, 2));

	}

}
