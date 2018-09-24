package test;

import java.util.HashMap;
import java.util.Map;

import a0_common.ListNode;

public class Z004_RemovedDuplicateFromLinkList {

	// class ListNode{
	// int val;
	// ListNode next;
	// public ListNode(int val){
	// this.val = val;
	// next = null;
	// }
	// }

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode curr = head;

		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}

	public static ListNode deleteDuplicatesUnOrder(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode curr = head;
		Map<Integer, Boolean> hash = new HashMap<>();
		hash.put(curr.val, true);
		while (curr != null && curr.next != null) {
			if (hash.containsKey(curr.next.val)) {
				curr.next = curr.next.next;
			} else {
				hash.put(curr.next.val, true);
				curr = curr.next;
			}
		}
		return head;
	}
}
