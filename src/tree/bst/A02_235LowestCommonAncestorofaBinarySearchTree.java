package tree.bst;

import common.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 * 
 * @author William
 *
 * 题目大意：
 * 		给定一棵二叉搜索树（BST），寻找BST中两个给定节点的最近公共祖先（LCA）。
 *
 * 		根据维基百科对LCA的定义：“节点v与w的最近公共祖先是树T上同时拥有v与w作为后继的最低节点（我们允许将一个节点当做其本身的后继）”
 *
 * 		例如，题目描述的样例中，节点2和8的最近公共祖先（LCA）是6。另一个例子，节点2和4的LCA是2，因为根据LCA的定义，一个节点可以是其本身的后继。
 *
 *
 * 解题思路：
 * 		根据BST的性质，左子树节点的值＜根节点的值，右子树节点的值＞根节点的值
 *
 * 		记当前节点为node，从根节点root出发
 *
 * 		若p与q分别位于node的两侧，或其中之一的值与node相同，则node为LCA
 *
 * 		否则，若p的值＜node的值，则LCA位于node的左子树
 *
 * 		否则，LCA位于node的右子树
 *
 * http://shmilyaw-hotmail-com.iteye.com/blog/2276803
 */
public class A02_235LowestCommonAncestorofaBinarySearchTree {


	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return root;
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}


	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null) {
			return q;
		}
		if (q == null) {
			return q;
		}

		TreeNode node = root;
		while (node != null) {
			if (node.val > p.val && node.val > q.val) {
				node = node.left;
			} else if (node.val < p.val && node.val < q.val) {
				node = node.right;
			} else {
				return node;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(0);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(9);
		TreeNode t8 = new TreeNode(3);
		TreeNode t9 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;

		t5.left = t8;
		t5.right = t9;

		System.out.println(lowestCommonAncestor(t1,t2,t3));
		System.out.println(lowestCommonAncestor(t1,t2,t5));
	}
}
