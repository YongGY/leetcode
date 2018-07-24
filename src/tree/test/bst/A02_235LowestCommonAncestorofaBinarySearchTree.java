package tree.test.bst;

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
 */
public class A02_235LowestCommonAncestorofaBinarySearchTree {


	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


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
