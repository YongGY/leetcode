package easy100_199;

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
 */
public class E160_IntersectionofTwoLinkedLists {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		return headB;
	}
}
