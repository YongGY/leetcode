package tree.bst;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 * 
 * @author William
 *
 *
 * 二叉搜索树（Binary Search Tree）
 *
 * 之所以称为二叉搜索树，是因为这种二叉树能大幅度提高搜索效率。
 *
 * 如果一个二叉树满足：对于任意一个节点，其值不小于左子树的任何节点，且不大于右子树的任何节点（反之亦可），则为二叉搜索树。
 *
 * 如果按照中序遍历，其遍历结果是一个有序序列。因此，二叉搜索树又称为二叉排序树。
 *
 * 不同于最大堆（或最小堆），其只要求当前节点与当前节点的左右子节点满足一定关系。
 *
 * 下面以非降序二叉搜索树为例。

 *   Asuming each node value is not equal
 *  *  A simple binary search tree
 *  *           6                  6
 *  *          / \                / \
 *  *         /   \              /   \
 *  *        3     8            3     8
 *  *       /     / \          /     / \
 *  *      /     /   \        /     /   \
 *  *     2     7     9      2     4*    9
 *  *
 *  *       (A) BST             (B) Not BST
 *  *
 * 其中（A）为二叉搜索树，（B）不是。因为根节点6小于右子树中的节点4。
 *
 */
public class A01_098ValidateBinarySearchTree {

	/**
	 *  如题, 验证是否是BST.
	 *
	 *  DFS
	 * - 查看每个parent-child关系: leftchild < root < rightChild
	 * - 方法: 把root.val 传下来作为 max 或者 min, 然后检查children
	 *
	 * ##### Note:
	 * - min/max需要时long type.
	 * - 如果题目真的给node.val = Integer.MAX_VALUE, 我们需要能够与之比较, long就可以.
	 */

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean isValidBST(TreeNode node, long minVal, long maxVal) {
		if (node == null) {
			return true;
		}
		if (node.val >= maxVal || node.val <= minVal) {
			return false;
		}
		return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
	}



 	public static void main(String[] args) {
 		
	}
}
