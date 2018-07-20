package tree.test.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author William
 *
 * http://www.voidcn.com/article/p-zllboida-brm.html
 *
 */
public class A02_103BinaryTreeZigzagLevelOrderTraversal {

	// 不会  没写
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

	}


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
//		TreeNode t6 = new TreeNode(8);

		t1.left =  t2;
		t1.right =  t3;

		t3.left =  t4;
		t3.right = t5;
//
//		t4.left = t6;
		System.out.println(zigzagLevelOrder(t1));
	}
}
