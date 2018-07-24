package tree.test.bst;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 * 
 * @author William

 *
 */
public class A01_098ValidateBinarySearchTree {


	public static boolean isValidBST(TreeNode root) {

	}

	/**
	 *  *  *           6                  6
	 *  *  *          / \                / \
	 *  *  *         /   \              /   \
	 *  *  *        3     8            3     8
	 *  *  *       /     / \          /     / \
	 *  *  *      /     /   \        /     /   \
	 *  *  *     2     7     9      2     4*    9
	 *  *  *
	 *  *  *       (A) BST             (B) Not BST
	 */

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(7);
//		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(9);

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;

		t3.left = t5;
		t3.right = t6;

		System.out.println(isValidBST(t1));
	}
}
