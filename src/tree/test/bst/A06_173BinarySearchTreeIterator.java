package tree.test.bst;

import common.TreeNode;

import java.util.Stack;

/**
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 * @author William
 *
 */
public class A06_173BinarySearchTreeIterator {


	class BSTIterator {

		public BSTIterator(TreeNode root) {

		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {

		}

		/**
		 * @return the next smallest number
		 */
		public int next() {

		}

	}

	 /**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	  *
	 *       4
	 *      / \
	 *     1   5
	 *      \   \
	 *      3    7
	 *     /    /
	 *    2    6
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(6);

		BSTIterator iterator = new A06_173BinarySearchTreeIterator().new BSTIterator(root);

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
