package tree.test.basic;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * 
 * @author William
 *
 * The key is using a stack to store left and right children, and push right child first so that it is processed after the left child.
 *
 */
public class A01_144BinaryTreePreorderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {

	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right =  t5;

		t3.right = t6;

		//[1, 2, 4, 5, 3, 6]
		System.out.println(preorderTraversal(t1));
	}

}
