package test;

import a0_common.ListNode;

public class Z005_IntersectionOfTwoLinkedLists {

	//160. Intersection of Two Linked Lists
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//boundary check
		if (headA == null || headB == null) {
			return null;
		}

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while (a != b) {
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = (a == null ? headB : a.next);
			b = (b == null ? headA : b.next);
		}
		return a;
	}
	
	//最后一种方法比较巧妙，就是利用了链表无环这个限定条件，即便两个链表长度不同，但是同时使用两个指针分别跑完两个链表，总是会在交叉点相遇，
	//也就是说第一个指针跑了x+n+y，第二个指针跑了y+n+x，然后二者相遇。
 
}
