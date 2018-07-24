package tree.test.bst;

import common.TreeNode;

/**
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * @author William
 *
 */
public class A09_285InorderSuccessorInBST {

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

	}


	// [BST InOrder Successor]
	public static TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {


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
		System.out.println(inorderSuccessor(root, new TreeNode(30)));
		System.out.println(inorderSuccessor1(root, new TreeNode(30)));
		System.out.println(inorderSuccessor2(root, new TreeNode(30)));

	}
}
