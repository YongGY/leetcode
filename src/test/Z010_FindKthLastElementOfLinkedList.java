package test;

import a0_common.ListNode;

public class Z010_FindKthLastElementOfLinkedList {

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
		ListNode n = new ListNode(11);
		n.next = new ListNode(21);
		n.next.next = new ListNode(81);
		n.next.next.next = new ListNode(31);
		n.next.next.next.next = new ListNode(71);
		n.next.next.next.next.next = new ListNode(0);
		n.next.next.next.next.next.next = new ListNode(41);
		n.next.next.next.next.next.next.next = new ListNode(91);
		Z010_FindKthLastElementOfLinkedList rm = new Z010_FindKthLastElementOfLinkedList();
		System.out.println(n);

		System.out.println("kthByRecursion="+rm.kthByRecursion(n, 2));
		System.out.println("kthByIteration="+rm.kthByIteration(n, 2));

	}

}
