package difficulty.easy1_199;

import a0_common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * 
 * 这道题是经典的双指针问题，用两个指针一前一后指向链表。
 * 
 * 如果两个指针指向的值相等，那么就让第二个指针一直往后挪，挪到与第一个指针不同为止。
 * 然后让第一个指针的next指向第二个指针，两个指针同时往后挪，进行下面的操作。
 * 
 * 需要注意，当list的结尾几个node是重复的时候，例如1->2->3->3，那么ptr2会指向null，需要特殊处理，令ptr1.next =
 * null，这样list尾部就不会丢。
 * 
 * 其他情况就不用特殊处理结尾了，因为结尾没有重复值，只须遍历就够了，不用特殊处理尾部。
 * 
 * @author William
 *
 */
public class E083_RemoveDuplicatesFromSortedList {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;
		while (curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode a = deleteDuplicates(l1);
		while (a.next != null) {
			System.out.println(a.val);
			a = a.next;
		}
		System.out.println(a.val);

	}

}
