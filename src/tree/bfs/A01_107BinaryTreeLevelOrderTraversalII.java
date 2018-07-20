package tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class A01_107BinaryTreeLevelOrderTraversalII {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelRecursion(root, 0, res);
		return res;
	}

	private static void levelRecursion(TreeNode node, int level, List<List<Integer>> res) {
		if (node == null) {
			return;
		}
		if (res.size() < level + 1) {// 说明还需要添加一行
			res.add(0, new ArrayList<>());
		}
		res.get(res.size() - 1 - level).add(node.val);

		levelRecursion(node.left, level + 1, res);
		levelRecursion(node.right, level + 1, res);
	}

//
//	public static  List<List<Integer>> levelOrderBottom(TreeNode root) {
//		List<List<Integer>> result = new ArrayList<>();
//
//		if (root == null) {
//			return result;
//		}
//
//		LinkedList<TreeNode> current = new LinkedList<>();
//		LinkedList<TreeNode> next = new LinkedList<>();
//		current.offer(root);
//
//		ArrayList<Integer> numberList = new ArrayList<>();
//
//		// need to track when each level starts
//		while (!current.isEmpty()) {
//			TreeNode head = current.poll();
//
//			numberList.add(head.val);
//
//			if (head.left != null) {
//				next.offer(head.left);
//			}
//			if (head.right != null) {
//				next.offer(head.right);
//			}
//
//			if (current.isEmpty()) {
//				current = next;
//				next = new LinkedList<>();
//				result.add(numberList);
//				numberList = new ArrayList<>();
//			}
//		}
//
//		//return Collections.reverse(result);
//		List<List<Integer>> reversedResult = new ArrayList<>();
//		for (int i = result.size() - 1; i >= 0; i--) {
//			reversedResult.add(result.get(i));
//		}
//		return reversedResult;
//	}
//

	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = queue.size(); // 记录每层的结点个数
		TreeNode tempNode = null;
		List<Integer> singleLevel = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (i == 0) {// 一层记录结束
				//
				result.addFirst(singleLevel);

				i = queue.size();
				singleLevel = new ArrayList<>();
			}
			tempNode = queue.poll();
			singleLevel.add(tempNode.val);

			--i;

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}

		}
		result.addFirst(singleLevel);
		return result;
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

		System.out.println(levelOrderBottom(t1));
	}
}
