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
 */
public class A110_BalancedBinaryTree {

	/**
	 * 题意是判断一棵二叉树是否是高度平衡的，所谓二叉树高度平衡指的是二叉树的每个节点的两棵子树的高度差都不超过 1.
	 *
	 * 那么我们只需计算左右子树的高度，判断其高度差是否不超过 1 即可，如果超过 1，就代表其不是高度平衡的，立即返回不是即可.
	 *
	 * 我这里用返回 -1 代表不是。
	 *
	 * 我们可以使用自底向上的方法，用-1作为false的indicator，将不满足条件的dfs直接剪掉。最后Time Complexity就是O(n)， Space Complexity也是O(n)。
	 */
	public static boolean isBalanced(TreeNode root) {
		return dfs(root) != -1;
	}

	private static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = dfs(root.left);
		if (leftDepth == -1) {
			return -1;
		}
		int rightDepth = dfs(root.right);
		if (rightDepth == -1) {
			return -1;
		}
		if (Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}

    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.left =  t2;
		t1.right =  t3;
		t3.left =  t4;
		t3.right = t5;
		System.out.println(isBalanced(t1));
		
		TreeNode t11 = new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t31 = new TreeNode(2);
		TreeNode t41 = new TreeNode(3);
		TreeNode t51 = new TreeNode(3);
		TreeNode t61 = new TreeNode(4);
		TreeNode t71 = new TreeNode(4);
		
		t11.left =  t21;
		t11.right =  t31;
		
		t21.left =  t41;
		t21.right = t51;
		
		t41.left =  t61;
		t41.right = t71;
		System.out.println(isBalanced(t11));
	}
}
