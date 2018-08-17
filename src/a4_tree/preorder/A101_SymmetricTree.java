package a4_tree.preorder;

import a0_common.TreeNode;

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
public class A101_SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return dfs(root.left, root.right);
	}

	private boolean dfs(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return dfs(p.left, q.right) && dfs(p.right, q.left);
	}
    
 	public static void main(String[] args) {
 		
	}
}
