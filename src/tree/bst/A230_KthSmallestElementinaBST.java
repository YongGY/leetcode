package tree.bst;

import java.util.Stack;

import a0_common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * Hint:
 *
 * 1.Try to utilize the property of a BST.
 * 2.What if you could modify the BST node's structure?
 * 3.The optimal runtime complexity is O(height of BST).
 *
 * @author William
 *
 * 二分查找数(BST)的性质
 * 任何一个节点的值均大于左子树的任意节点值，而小于右子树的任一节点值。
 * 那么这样就可以知道最小值的一个节点在树的最左端，最大值的一个节点在树的最右端。
 * 树从小到大顺序刚好满足树的中序遍历。因而，我们可以用中序遍历来处理。
 *
 */
public class A230_KthSmallestElementinaBST {

	private static int count = 0;
	private static int res = 0;

	public static int kthSmallest(TreeNode root, int k) {
		inOrder(root, k);
		return res;
	}

	private static void inOrder(TreeNode root, int k) {
		if (root == null || count >= k) {
			return;
		}
		inOrder(root.left, k);
		count++;
		if (count == k) {
			res = root.val;
		}
		inOrder(root.right, k);
	}


	public int kthSmallest1(TreeNode root, int k) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null) {
			s.push(root);
			root = root.left;
		}
		while (!s.isEmpty()) {
			TreeNode curr = s.pop();
			k--;
			if (k == 0) {
				return curr.val;
			}
			if (curr.right != null) {
				curr = curr.right;
				while (curr != null) {
					s.push(curr);
					curr = curr.left;
				}
			}
		}
		return 0;
	}


	/**
	 *        8
	 *      /  \
	 *     3    10
	 *    / \     \
	 *   1   6     14
	 *      / \    /
	 *     4   7  13
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(3);
		TreeNode l3 = new TreeNode(6);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(7);
		TreeNode l6 = new TreeNode(10);
		TreeNode l7 = new TreeNode(14);
		TreeNode l8 = new TreeNode(13);
		root.left = l2;
		root.right = l6;
		l2.left = l1;
		l2.right = l3;
		l3.left = l4;
		l3.right = l5;
		l6.right = l7;
		l7.left = l8;
		kthSmallest(root,3);
		System.out.println(A230_KthSmallestElementinaBST.res);
	}
}
