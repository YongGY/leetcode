package tree.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import a0_common.TreeNode;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author William
 *
 */
public class A102_BinaryTreeLevelOrderTraversal {


	/**
	 * #### DFS
	 * - 每个level都应该有个ArrayList. 那么用一个int level来查看：是否每一层都有了相应的ArrayList。
	 * - 如果没有，就加上一层。
	 * - 之后每次都通过DFS在相应的level上面加数字
	 *
	 * Solution : DFS 	Time: O(n)
	 */
	public static List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, 0, res);
		return res;
	}

	private static void dfs(TreeNode node, int level, List<List<Integer>> res) {
		if (node == null) {
			return;
		}
		if (level == res.size()) {
			res.add(new ArrayList<>());
		}

		res.get(level).add(node.val);
		dfs(node.left, level + 1, res);
		dfs(node.right, level + 1, res);
	}





	/**
	 * #### BFS
	 * - 最普通,Non-recursive: BFS, queue, 用个queue.size()来end for loop:换行。
	 * - 或者用两个queue. 当常规queue empty，把backup queue贴上去
	 *
	 * Solution : BFS Time: O(n)
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				TreeNode node = queue.poll(); //返回第一个元素，并在队列中删除
				tmp.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			res.add(tmp);
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

		System.out.println(levelOrder(t1));
//		System.out.println(levelOrder1(t1));

	}
}
