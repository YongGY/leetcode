package difficulty.easy1_199;

import common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * 
 * 题意： 给定两颗二叉树，判断这两颗树是否相同，它们相同的条件是结构相同，对应节点的值也必须相同。 
 * 二叉树相等：两棵树的结构相同，且结点值相等。
 * 
 * 分析：
 * 使用递归进行求解，先判断当前结点值是否相等平；如果相等就再比较其左右子树，只有当所有的结点都相等才相等。
 * 
 * 先比较对应点的节点是否为空，
 * 如果都为空，那么在当前状态下返回true；
 * 如果一个空，一个不为空，返回false。
 * 如果都不为空的情况下，判断对应点的值，如果值不同返回false；
 * 如果值相同，递归判断当前节点的子树。
 * 
 * @author William
 *
 */
public class E100_SameTree {
 

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null) ) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
