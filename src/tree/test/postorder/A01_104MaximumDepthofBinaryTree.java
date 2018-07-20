package tree.test.postorder;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 * return its depth = 3.
 * 
 * @author William
 *
 */
public class A01_104MaximumDepthofBinaryTree {


	public static int maxDepth(TreeNode root) {

	}


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(8);

		t1.left =  t2;
		t1.right =  t3;

		t3.left =  t4;
		t3.right = t5;

		t4.left = t6;
		System.out.println(maxDepth(t1));
	}
}
