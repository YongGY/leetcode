package tree.test.preorder;

import common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * 
 * @author William
 *
 */
public class A09_111MinimumDepthofBinaryTree {

	public static int minDepth(TreeNode root) {

	}

 

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;

		right.left = new TreeNode(15);
		right.right = new TreeNode(7);

		System.out.println(minDepth(root));
	}
}
