package tree.basic;

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
 *
 * 二叉树先序遍历， root -> left -> right。
 * 使用一个栈来维护已经访问过的节点。
 * 当root不为空时，当前节点入栈，输出节点值，继续向左子树遍历。
 * 当root为空，从栈中弹出节点，向右子树进行遍历。
 *
 * https://www.jianshu.com/p/456af5480cee
 *
 * https://blog.csdn.net/soundwave_/article/details/53120766
 *
 * 二叉树的遍历分为以下三种：
 *
 * 先序遍历：遍历顺序规则为【根左右】
 *
 * 中序遍历：遍历顺序规则为【左根右】
 *
 * 后序遍历：遍历顺序规则为【左右根】
 *
 */
public class A01_144BinaryTreePreorderTraversal {


	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(res,root);
		return res;
	}

	public static void dfs(List<Integer> res, TreeNode root) {
		if(root == null){
			return;
		}
		res.add(root.val);
		dfs(res,root.left);
		dfs(res,root.right);
	}

	public static List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if(root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.empty()){
			TreeNode n = stack.pop();
			res.add(n.val);

			if(n.right != null){
				stack.push(n.right);
			}
			if(n.left != null){
				stack.push(n.left);
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

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right =  t5;

		t3.right = t6;

		System.out.println(preorderTraversal(t1));
		System.out.println(preorderTraversal1(t1));
	}

}
