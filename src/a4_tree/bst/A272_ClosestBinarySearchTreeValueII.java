package a4_tree.bst;

import java.util.LinkedList;
import java.util.List;

import a0_common.TreeNode;

/**
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 *
 * Hint:
 *
 * Consider implement these two helper functions:
 * getPredecessor(N), which returns the next smaller node to N.
 * getSuccessor(N), which returns the next larger node to N.
 * Try to assume that each node has a parent pointer, it makes the problem much easier.
 * Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 * You would need two stacks to track the path in finding predecessor and successor node separately.
 * 
 * @author William
 *
 */
public class A272_ClosestBinarySearchTreeValueII {

	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> res = new LinkedList<>();
		inOrderTraversal(root, target, k, res);
		return res;
	}

	private static void inOrderTraversal(TreeNode root, double target, int k, LinkedList<Integer> res) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, target, k, res);
		if (res.size() < k) {
			res.add(root.val);
		} else if (res.size() == k) {
			if (Math.abs(res.getFirst() - target) > Math.abs(root.val - target)) {
				res.removeFirst();
				res.addLast(root.val);
			} else {
				return;
			}
		}
		inOrderTraversal(root.right, target, k, res);
	}

	/**
	 *         20
	 *       /    \
	 *     10      30
	 *    /  \    /  \
	 *   5   15  25  35
	 *   \   / \
	 *   7  13  18
	 */

	public static void main(String[] args) {
		//5, 7, 10, 13, 15, 18, 20, 25, 30, 35
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		root.left.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(18);
		System.out.println(closestKValues(root, 9,3));

	}
}
