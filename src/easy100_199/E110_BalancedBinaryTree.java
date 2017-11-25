package easy100_199;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1
 * 
 * @author William
 * 
 *
 * 
 */
public class E110_BalancedBinaryTree {

	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
