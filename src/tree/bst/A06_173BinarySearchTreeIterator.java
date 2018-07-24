package tree.bst;

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

	private Stack<TreeNode> stk;

	class BSTIterator {

		public BSTIterator(TreeNode root) {
			stk = new Stack<>();
			// 先找到第一个节点，并把路径入栈
			while (root != null) {
				System.out.println(root.val);
				stk.push(root);
				root = root.left;
			}
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			// 栈为空时不再有下一个
			return !stk.isEmpty();
//			return stk.size() != 0;
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			TreeNode curr = stk.pop();
			TreeNode node = curr.right;   // 如果该元素有右节点，把它的右节点及右节点的所有左边节点都压入栈中
			while (node != null) {
				stk.push(node);
				node = node.left;
			}
			return curr.val;
		}

//		public Stack aa() {
//			return stk;
//		}
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

//		System.out.println(iterator.aa());

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
