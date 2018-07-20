package tree.test.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 
 * @author William
 *
 */
public class A03_199BinaryTreeRightSideView {



	public static List<Integer> rightSideView(TreeNode root) {

	}




	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
//		TreeNode t6 = new TreeNode(6);
//		TreeNode t7 = new TreeNode(7);

		t1.left =  t2;
		t1.right =  t3;

		t2.right = t5;
		t3.right = t4;

//		t5.left = t6;
//		t4.left = t7;

		System.out.println(rightSideView(t1));
	}
}
