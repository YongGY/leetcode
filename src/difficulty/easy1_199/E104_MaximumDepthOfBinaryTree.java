package difficulty.easy1_199;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node
 * 
 * @author William
 *
 */
public class E104_MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
