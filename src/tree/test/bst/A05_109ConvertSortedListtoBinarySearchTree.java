package tree.test.bst;

import common.ListNode;
import common.TreeNode;

/**
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author William
 *
 * 题解：
 *
 * 后来看了discuss版里1337大神说要自底向上构建，这样就不用每次找中点了。方法是in-order traversal + DFS自底向上，很巧妙。
 *
 * 以后假如自顶向下不好实现的话不妨试一试自底向上。不过in general一般还是用自顶向下。
 *
 */
public class A05_109ConvertSortedListtoBinarySearchTree {

	public static TreeNode sortedListToBST(ListNode head) {

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(-10);
		ListNode l2 = new ListNode(-3);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(sortedListToBST(l1));
	}
}
