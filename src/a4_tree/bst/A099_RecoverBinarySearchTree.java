package a4_tree.bst;

import a0_common.TreeNode;

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
public class A099_RecoverBinarySearchTree {


	/**
	 * 解答：
	 * 想法很简单，找到两个顺序不对的点，交换。但是如何知道这两个点的顺序是不对的呢？因为BST是左<中<右，所以我们可以用in-order traverse的方法：
	 */
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

		A099_RecoverBinarySearchTree a = new A099_RecoverBinarySearchTree();
		a.recoverTree(root);
		System.out.println(root);
 	}
}
