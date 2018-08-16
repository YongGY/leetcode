package tree.postorder;

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
public class A124_BinaryTreeMaximumPathSum {


	static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		dfs(root);
		return max;
	}

	//Path pass parent node only once at every node, either add its left or right path or nth for n
	private static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lmax = Math.max(0, dfs(root.left));        // left single path
		int rmax = Math.max(0, dfs(root.right));       // right single path
		max = Math.max(max, lmax + rmax + root.val);   // compare combo max with global max
		return root.val + Math.max(lmax, rmax);        // always return the max single continuous path
	}


	public static void main(String[] args) {
//		TreeNode t1 = new TreeNode(-10);
//		TreeNode t2 = new TreeNode(9);
//		TreeNode t3 = new TreeNode(20);
//		TreeNode t4 = new TreeNode(15);
//		TreeNode t5 = new TreeNode(7);
//
//		t1.left =  t2;
//		t1.right =  t3;
//
//
//		t3.left =  t4;
//		t3.right = t5;
//
//		System.out.println(maxPathSum(t1));

		TreeNode t11 = new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t31 = new TreeNode(3);

		t11.left =  t21;
		t11.right =  t31;
		System.out.println(maxPathSum(t11));

	}
}
