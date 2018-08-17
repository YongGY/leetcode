package a4_tree.preorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import a0_common.TreeNode;

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
public class A113_PathSumII {

	/**
	 * 深度搜索即可，用一个变量记录当前路径，一旦获得满足条件的路径，记录到最终结果中.
	 *
	 * 不管对不对,temp里都要加进那个节点,然后进行下面的dfs,但是有可能这条路径不成功, 那么当程序都走完(左右都试过)还不成功,
	 * 说明这个节点无论如何都不行,就要退一步, 把刚加进去的值给删掉, 只删它一个. 再去走别的路, temp是反复重复利用的,
	 * 它里面除了root一直在里面, 其他值基本上是一直在被删的状态中. 这个题就是不停的去试, 试了不行就删掉.
	 *
	 * 一个很重要的问题, 把temp加到res里面, temp就没有了, 不能进行下面的了. 所以加进res的时候要复制一个temp加进去, 让temp保持原样.
	 * ArrayList-- path.remove(int i) remove element in index i
	 */

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
			res.add(new ArrayList<>(tmp));
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
