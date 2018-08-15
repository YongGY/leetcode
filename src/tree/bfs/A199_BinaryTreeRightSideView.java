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
public class A199_BinaryTreeRightSideView {

	/**
	 * 	思路: DFS
	 * 	preorder改一下顺序，从右走的左边.
	 * 	To ensure rightmost node of depth,Key is we ensure we only add the first node of the specific depth by check depth == list size.
	 * 	for ex, if we add node at depth 1 from right subtree, we won't add it again when travel the left subtree
	 */

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 0, res);
		return res;
	}

	private static void dfs(TreeNode root, int level, List<Integer> res) {
		if (root == null) {
			return;
		}

		if (level == res.size()) { // 当等于size的时候说明是最右侧结点，直接加入即可
			res.add(root.val);
		}
		dfs(root.right, level + 1, res);
		dfs(root.left, level + 1, res);
	}


	/**
	 * 思路： BFS
	 * use level order traverlsal. key is to track each level size, and add the 1ast one to list.
	 *  2. BFS时，先左子树后右子树，每一层对应一个值，保存最后一个Queue里的值。
	 */

	public static List<Integer> rightSideView1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {//traveling current level
				TreeNode curr = queue.poll();
				if (i == size - 1) {
					res.add(curr.val);
				}
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
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
		System.out.println(rightSideView1(t1));
	}
}
