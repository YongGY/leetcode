package tree.test.postorder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * 		Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Returns [4, 5, 3], [2], [1].
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *           1
 *          /
 *         2
 * 2. Now removing the leaf [2] would result in this tree:
 *           1
 * 3. Now removing the leaf [1] would result in the empty tree:
 *           []
 * Returns [4, 5, 3], [2], [1].
 * 
 * @author William
 *
 *
 */
public class A05_366FindLeavesofBinaryTree {

	public static List<List<Integer>> findLeaves(TreeNode root) {

	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right = t5;

		System.out.println(findLeaves(t1));
	}
}
