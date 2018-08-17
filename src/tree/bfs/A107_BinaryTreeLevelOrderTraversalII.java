package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import a0_common.TreeNode;

/**
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author William
 *
 */
public class A107_BinaryTreeLevelOrderTraversalII {

	/**
	 * #### DFS
	 * - 根据level来append每个list
	 * - rst里面add(0,...)每次都add在list开头
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, 0, res);
		return res;
	}

	private static void dfs(TreeNode node, int level, List<List<Integer>> res) {
		if (node == null) {
			return;
		}
		if (level == res.size()) {
			res.add(0, new ArrayList<>());
		}
		res.get(res.size() - 1 - level).add(node.val);
		dfs(node.left, level + 1, res);
		dfs(node.right, level + 1, res);
	}

	/**
	 * #### BFS
	 * - 跟Binary Tree Level Order Traversal一样,只不过存result一直存在存在0位.
	 */
	public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			res.add(0, list);
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;

		t3.left = t4;
		t3.right = t5;

		System.out.println(levelOrderBottom(t1));
		System.out.println(levelOrderBottom1(t1));
	}
}
