package tree.test.bst;

import common.TreeNode;

/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * 
 * @author William
 *
 */
public class A03_236LowestCommonAncestorofaBinaryTree {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		if( p == null || q == null){
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left != null && right != null){
			return root;
		}else{
			return left != null ? left : right;
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(0);
		TreeNode t7 = new TreeNode(8);
		TreeNode t8 = new TreeNode(7);
		TreeNode t9 = new TreeNode(4);

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;

		t5.left = t8;
		t5.right = t9;

		System.out.println(lowestCommonAncestor(t1,t2,t3));
//		System.out.println(lowestCommonAncestor(t1,t2,t9));
	}
}
