package difficulty.easy1_199;

import a0_common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author William
 * 
 *
 * 
 */
public class E111_MinimumDepthofBinaryTree {


	//DFS
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth(root.right) + 1;
		else if (root.right == null)
			return minDepth(root.left) + 1;
		else
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
