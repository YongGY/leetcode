package tree.level;

import common.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 
 * @author William
 *
 */
public class A02_114FlattenBinaryTreetoLinkedList {

	/**
	 * 递归方法：
	 * 		自下而上
	 *
	 * 非递归方法：自上而下
	 * 		从上到下依次寻找左子结点，并且把它挂在右子结点的位置上
	 * 		原本的右子结点挂在左子节点的最后一个右子结点上
	 */

	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode cur = root.left;
				while (cur.right != null) {
					cur = cur.right;
				}
				cur.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}


	public TreeNode lastNode = null;

	public void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}

		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}

		lastNode = root;
		TreeNode right = root.right;
		flatten1(root.left);
		flatten1(right);
	}

 	public static void main(String[] args) {
 		
	}
}
