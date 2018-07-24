package tree.test.preorder;

import common.TreeNode;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author William
 *
 */
public class A02_101SymmetricTree {

	public boolean isSymmetric(TreeNode root) {

	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;


		System.out.println(isSymmetric(root));
	}
}