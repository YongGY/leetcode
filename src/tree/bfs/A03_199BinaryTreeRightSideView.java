package tree.bfs;

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

	/**
	 * 	思路: DFS
	 * 	preorder改一下顺序，从右走的左边.
	 * 	To ensure rightmost node of depth,Key is we ensure we only add the first node of the specific depth by check depth == list size.
	 * 	for ex, if we add node at depth 1 from right subtree, we won't add it again when travel the left subtree
	 */

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		traverse(root, 0, res);
		return res;
	}

	private static void traverse(TreeNode root, int level, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (level == res.size()) { // 当等于size的时候说明是最右侧结点，直接加入即可
			res.add(root.val);
		}
		traverse(root.right, level + 1, res);
		traverse(root.left, level + 1, res);
	}


	/**
	 * 思路： BFS
	 * use level order traverlsal. key is to track each level size, and add the 1ast one to list.
	 */


	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> qu = new LinkedList<>();
		if (root == null) return res;
		qu.offer(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {//traveling current level
				TreeNode curr = qu.remove();
				if (i == size - 1) {
					res.add(curr.val);
				}
				if (curr.left != null) {
					qu.offer(curr.left);
				}
				if (curr.right != null) {
					qu.offer(curr.right);
				}
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
		TreeNode t7 = new TreeNode(7);

		t1.left =  t2;
		t1.right =  t3;

		t2.right = t5;
		t3.right = t4;

		t5.left = t6;
		t4.left = t7;

		System.out.println(rightSideView(t1));
	}
}
