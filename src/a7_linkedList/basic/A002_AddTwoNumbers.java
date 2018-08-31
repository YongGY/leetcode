package a7_linkedList.basic;

import a0_common.ListNode;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * @author William
 *
 */
public class A002_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		if(l1 == null && l2 == null){
			return head;
		}
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		int sum = 0;
		int carry = 0;
		ListNode curr = head;
		while(l1 != null || l2 != null){
			int num1 = (l1 == null ? 0 : l1.val);
			int num2 = (l2 == null ? 0 : l2.val);
			sum = num1 + num2 + carry;
			curr.next = new ListNode(sum % 10);
			carry = sum / 10;
			curr = curr.next;
			l1 = (l1 == null ? null : l1.next);
			l2 = (l2 == null ? null : l2.next);

			if(carry > 0){
				curr.next = new ListNode(carry);
			}
		}
		return head.next;
	}


 	public static void main(String[] args) {
 		
	}
}
