package test;

import a0_common.TreeNode;

public class Y003_ConvertSortedArrayToBinarySearchTree {

	
	 /**
	  * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

		For this problem, a height-balanced binary tree is defined as a binary tree in 
		which the depth of the two subtrees of every node never differ by more than 1.
		
		Example:
		
		Given the sorted array: [-10,-3,0,5,9],
		
		One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

		      0
		     / \
		   -3   9
		   /   /
		 -10  5
	  */
	
	// 108. Convert Sorted Array to Binary Search Tree
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode r = new TreeNode(nums[mid]);
		r.left = helper(nums, left, mid - 1);
		r.right = helper(nums, mid + 1, right);
		return r;
	}


}
