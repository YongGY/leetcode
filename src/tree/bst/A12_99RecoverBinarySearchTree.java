package tree.bst;

import common.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * Input: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Example 2:
 * Input: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * 
 * @author William
 *
 */
public class A12_99RecoverBinarySearchTree {

	TreeNode firstNode;
	TreeNode secondNode;
	TreeNode lastNode;

	public void recoverTree(TreeNode root) {
		inorder(root);
		int tmp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = tmp;
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (lastNode != null && firstNode == null && lastNode.val >= root.val) {
			firstNode = lastNode;
		}
		if (lastNode != null && firstNode != null && lastNode.val >= root.val) {
			secondNode = root;
		}
		lastNode = root;
		inorder(root.right);
	}

 	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);

		A12_99RecoverBinarySearchTree a = new A12_99RecoverBinarySearchTree();
		a.recoverTree(root);
		System.out.println(root);
 	}
}
