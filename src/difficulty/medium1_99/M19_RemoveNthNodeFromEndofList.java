package difficulty.medium1_99;

import java.util.List;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author William
 *
 *
 *         题解：
 * 
 *         这道题也是经典题，利用的是faster和slower双指针来解决。
 * 
 *         首先先让faster从起始点往后跑n步。
 * 
 *         然后再让slower和faster一起跑，直到faster==null时候，slower所指向的node就是需要删除的节点。
 * 
 *         注意，一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点。
 * 
 *         为了方便起见，当让slower和faster同时一起跑时，就不让faster跑到null了，让他停在上一步，faster.next==null时候，这样slower就正好指向要删除节点的上一个节点，充当了prev指针。
 *         这样一来，就很容易做删除操作了。
 * 
 *         slower.next = slower.next.next(类似于prev.next = prev.next.next)。
 * 
 *         同时，这里还要注意对删除头结点的单独处理，要删除头结点时，没办法帮他维护prev节点，所以当发现要删除的是头结点时，直接让head =
 *         head.next并returnhead就够了。
 *
 */
public class M19_RemoveNthNodeFromEndofList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}


	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode faster = head;
		ListNode slower = head;
		for (int i = 0; i < n; i++) {
			faster = faster.next;
		}

		if (faster == null) {
			head = head.next;
			return head;
		}

		while (faster.next != null) {
			slower = slower.next;
			faster = faster.next;
		}

		slower.next = slower.next.next;
		return head;

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
