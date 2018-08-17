package a4_tree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import a0_common.TreeNode;

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
public class A144_BinaryTreePreorderTraversal {

	/**
	 * #### Recursive
	 * - 加root, left, then right. Obvious
	 * - Divide and conquer
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}

	private static void dfs(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		res.add(node.val);
		dfs(node.left, res);
		dfs(node.right, res);
	}


	/**
	 * #### Iterative
	 */
	public static List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();

		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				result.add(root.val);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return result;
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

		System.out.println(preorderTraversal(t1));
		System.out.println(preorderTraversal1(t1));
	}

}
