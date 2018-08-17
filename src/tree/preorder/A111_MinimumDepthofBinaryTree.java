package tree.preorder;

import java.util.LinkedList;
import java.util.Queue;

import a0_common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 * 
 * @author William
 *
 */
public class A111_MinimumDepthofBinaryTree {

	/**
	 * DFS遍历，返回左子树或者右子树中小的深度加1，作为自己的深度即可；但要先判断坐子树或者右子树为空的情况
	 */

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		else if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		else {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}

	/**
	 * BFS层序遍历，遇到 左子树和右子树都是 null 即返回
	 */
	public static int minDepth1(TreeNode root) {
		int level = 0;
		if (root == null) {
			return level;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		int curNum = 0;
		int lastNum = 1;

		queue.offer(root);
		level = 1;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			lastNum--;
			if (cur.left == null && cur.right == null) {  //判断是否返回在这里
				return level;
			}
			if (cur.left != null) {
				queue.add(cur.left);
				curNum++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				curNum++;
			}
			if (lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}
		return 0;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;

		right.left = new TreeNode(15);
		right.right = new TreeNode(7);

		System.out.println(minDepth(root));
		System.out.println(minDepth1(root));

		
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		root1.left = left1;

		System.out.println(minDepth(root1));
		System.out.println(minDepth1(root1));

	}
}
