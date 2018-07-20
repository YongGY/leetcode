package tree.postorder;

import common.TreeNode;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * @author William
 *
 * 维护一个值：
 * >=0 : 层数
 * -1  : 不balanced
 *
 */
public class A02_110BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return dfs(root) >= 0;
	}

	private int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = dfs(node.left);
		int right = dfs(node.right);
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		if (left < 0 || right < 0) {
			return -1;     //重要！！！
		}
		return Math.max(left, right) + 1;
	}
    
 	public static void main(String[] args) {
 		
	}
}
