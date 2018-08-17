package a4_tree.postorder;

import java.util.LinkedList;
import java.util.Queue;

import a0_common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 * 
 * @author William
 *
 */
public class A104_MaximumDepthofBinaryTree {


	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return maxDepth(root.right) + 1;
		} else if (root.right == null) {
			return maxDepth(root.left) + 1;
		} else {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}


	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
	}

	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int curLevel = 1;
		int nextLevel = 0;
		int depth = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			curLevel--;
			if (node.left != null) {
				q.offer(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				q.offer(node.right);
				nextLevel++;
			}
			if (curLevel == 0) {
				curLevel = nextLevel;
				nextLevel = 0;
				depth++;
			}
		}
		return depth;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(8);

		t1.left =  t2;
		t1.right =  t3;

		t3.left =  t4;
		t3.right = t5;

		t4.left = t6;
//		System.out.println(maxDepth1(t1));
	}
}
