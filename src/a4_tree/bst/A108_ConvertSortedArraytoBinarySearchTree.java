package a4_tree.bst;

import a0_common.TreeNode;

/**
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author William
 *
 */
public class A108_ConvertSortedArraytoBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		return buildTree(num, 0, num.length - 1);
	}

	private static TreeNode buildTree(int[] num, int left, int right) {
		if (left > right) { // Done
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = buildTree(num, left, mid - 1);
		node.right = buildTree(num, mid + 1, right);
		return node;
	}
    
 	public static void main(String[] args) {
 		System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
	}
}
