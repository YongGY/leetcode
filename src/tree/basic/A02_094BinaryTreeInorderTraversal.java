package tree.basic;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author William
 *
 * The key to solve inorder traversal of binary tree includes the following:
 *
 * The order of "inorder" is: left child -> parent -> right child
 * Use a stack to track nodes
 * Understand when to push node into the stack and when to pop node out of the stack
 *
 */
public class A02_094BinaryTreeInorderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}

	private static void dfs(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			dfs(node.left, res);
		}

		res.add(node.val);

		if (node.right != null) {
			dfs(node.right, res);
		}
	}


	public static List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
		    return res;
        }
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.right = t6;

		System.out.println(inorderTraversal(t1));
		System.out.println(inorderTraversal1(t1));


		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		root.left.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(18);
		System.out.println(inorderTraversal(root));

	}
}
