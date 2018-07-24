package tree.test.bst;

import common.TreeNode;

/**
 * Difficulty: Easy
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 * @author William
 *
 */
public class A10_270ClosestBinarySearchTreeValue {


	/**
	 * #### Binary Search
	 * - 记录找到过的closest
	 * - Binary Search, 根据current node走位,
	 * - 找到 node.val == target, 或者走位走完, return closest
	 *
	 * Thoughts:
	 * Binary search, maintain a closest value.
	 * Note: initial closest in real case is just the root, since we start from the root
	 *
	 *
	 */

	public static int closestValue(TreeNode root, double target) {

	}

	/**
	 * #### Recursive
	 * - when less than curr val, consider left
	 * - when greater than curr val, consider right
	 * - dfs到底, 然后每一层比较, 再return
	 *
	 * Thoughts:
	 * dfs, before going into the left/right child, compare target with root, leftChild and rightChild see if a match
	 *
	 */

	public static int closestValue1(TreeNode root, double target) {

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
		System.out.println(closestValue(root, 7));
		System.out.println(closestValue1(root, 7));

	}
}
