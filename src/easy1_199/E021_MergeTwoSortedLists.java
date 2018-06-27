package easy1_199;

import common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author yongguo
 *
 */
public class E021_MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// 创建新的链表，存放list1和list2
		ListNode dummy = new ListNode(0); // 创建一个头结点，最后还要删除掉

		/*
		 * 新链表的第一个结点问题，由于一般情况下第一个结点都需要特殊处理，比较实用的解决办法是在第一个结点前增加一个虚拟的头结点(本例中的dummy
		 * )， 讲实际的第一个结点一般化。最后输出的时候输出这个虚拟结点的下一个结点就OK
		 */
		ListNode curr = dummy; // lastNode向了dummy的头 //设一个curr指针，初始指向dummy的头节点

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1; // 把小的值留下，留在在lastNode.next，lastNode指向L1(头) 或
								// lastNode.next 就是l1的头
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next; // 移动到新的尾结点
		}

		if (l1 != null) {
			curr.next = l1;
		} else {
			curr.next = l2;
		}

		return dummy.next; // dummy的下一个节点是第一个数据结点
	}

	public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val > l2.val) {
			ListNode tmp = l2;
			tmp.next = mergeTwoLists(l1, l2.next);
			return tmp;
		} else {
			ListNode tmp = l1;
			tmp.next = mergeTwoLists(l1.next, l2);
			return tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l14 = new ListNode(4);
		l1.next = l12;
		l12.next = l14;

		ListNode l2 = new ListNode(3);

		ListNode a = mergeTwoLists(l1, l2);
		while (a.next != null) {
			System.out.println(a.val);
			a = a.next;
		}

	}

}
