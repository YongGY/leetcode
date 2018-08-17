package tree.bst;

import a0_common.ListNode;
import a0_common.TreeNode;

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
public class A109_ConvertSortedListtoBinarySearchTree {

	public static TreeNode sortedListToBST(ListNode head) {
		ListNode tempHead = head;
		int count = 0;
		while (tempHead != null) {
			count++;
			tempHead = tempHead.next;
		}
		int[] nums = new int[count];
		count = 0;
		while (head != null) {
			nums[count++] = head.val;
			head = head.next;
		}
		return buildBST(nums, 0, nums.length - 1);
	}

	private static TreeNode buildBST(int[] nums, int left, int right) {
		if (left > right) return null;
		if (left == right) {
			return new TreeNode(nums[left]);
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(nums, left, mid - 1);
		root.right = buildBST(nums, mid + 1, right);
		return root;
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
