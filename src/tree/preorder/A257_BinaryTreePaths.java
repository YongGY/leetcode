package tree.preorder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @author William
 *
 */
public class A257_BinaryTreePaths {

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		dfs(root, "", res);
		return res;
	}

	private static void dfs(TreeNode root, String tmp, List<String> res) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			res.add(tmp + root.val);
		}
		dfs(root.left, tmp + root.val + "->", res);
		dfs(root.right, tmp + root.val + "->", res);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		t2.right =  t5;

		System.out.println(binaryTreePaths(t1));
	}
}
