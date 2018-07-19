package tree.preorder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * @author William
 *
 */
public class A06_113PathSumII {

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new LinkedList<>();
		dfs(root, sum, tmp, res);
		return res;
	}

	private static void dfs(TreeNode node, int sum, List<Integer> tmp, List<List<Integer>> res) {
		if (node == null) {
			return;
		}

		tmp.add(node.val);
		if (node.left == null && node.right == null && sum == node.val) {
			res.add(new LinkedList(tmp));
		} else {
			dfs(node.left, sum - node.val, tmp, res);
			dfs(node.right, sum - node.val, tmp, res);
		}
		tmp.remove(tmp.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;

		left.left = new TreeNode(11);
		left.left.left = new TreeNode(7);
		left.left.right = new TreeNode(2);

		right.left = new TreeNode(13);
		right.right = new TreeNode(4);
		right.right.left = new TreeNode(5);
		right.right.right = new TreeNode(1);

		System.out.println(pathSum(root, 22));
	}


}
