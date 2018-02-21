package easy1_199;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:    	a1 → a2
 *                  ↘
 *                      c1 → c2 → c3
 *                  ↗            
 * B:     b1 → b2 → b3
 * 
 * begin to intersect at node c1
 * @author William
 * 
 * 题目大意
 * 		找两个单链表的交集部分。 
 * 		如果没有交集返回null。 
 * 		函数操作后，单链表必须返回他们原来的结构。 
 * 		假定整个链表中没有环。 
 * 		函数必须在O(N)时间复杂度，O(1)空间复杂度以内完成。 
 * 解题思路
 * 		先将其中一个链表的链头按到另一个链表的尾部，
 * 		如果他们有交集则会构成一个环，
 * 		题目等价于找链表中的环的起始结点。找到后将链表还原
 */
public class E160_IntersectionofTwoLinkedLists_____Locked {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode ta; // 用于记录headA链表的尾结点
        ListNode ha = headA;
		
		return headB;
	}
}
