package tree.test.postorder;

import common.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * 
 * @author William
 *
 */
public class A03_124BinaryTreeMaximumPathSum {


 	public static  int maxPathSum(TreeNode root) {

	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(-10);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);

		t1.left =  t2;
		t1.right =  t3;


		t3.left =  t4;
		t3.right = t5;

		System.out.println(maxPathSum(t1));
	}
}
