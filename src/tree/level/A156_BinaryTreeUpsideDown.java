package tree.level;

import a0_common.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * 
 * @author William
 *
 */
public class A156_BinaryTreeUpsideDown {

	/**
	 * 	思路1：Recursion, find the leftmost node as the root. Return repoint each new parent - root.left to previous root and root.right;
	 * 	Complexity: O(N)time, O(N)space stack
	 */

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		//root.left is newRoot everytime
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}

	/**
	 * 	思路2: Iterative, pre is previous root after repoint, use tmp to track the right node of previous root.
	 * 	Complexity: O(N)time O(1)space
	 */

	public TreeNode upsideDownBinaryTree1(TreeNode root) {
		TreeNode cur = root;
		TreeNode pre = null;
		TreeNode tmp = null;
		TreeNode next = null;
		while (cur != null) {
			next = cur.left;
			//need tmp to keep the previous right child
			cur.left = tmp;
			tmp = cur.right;

			cur.right = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
    
 	public static void main(String[] args) {
 		System.out.println( );
	}
}
