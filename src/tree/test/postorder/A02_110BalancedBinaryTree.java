package tree.test.postorder;

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

	public static  boolean isBalanced(TreeNode root) {

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
