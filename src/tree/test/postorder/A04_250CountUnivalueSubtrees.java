package tree.test.postorder;

import common.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 *
 * return 4.
 * 
 * @author William

 */
public class A04_250CountUnivalueSubtrees {


	public static int countUnivalSubtrees(TreeNode root) {

	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;


		t2.left =  t4;
		t2.right = t5;
		t3.right = t6;

		System.out.println(countUnivalSubtrees(t1));
	}
}
