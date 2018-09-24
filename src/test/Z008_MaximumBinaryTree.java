package test;

import a0_common.TreeNode;

public class Z008_MaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructHelper(nums, 0, nums.length - 1);
	}

	public TreeNode constructHelper(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		if (l == r) {
			return new TreeNode(nums[l]);
		}
		int ma_idx = l;
		for (int i = l + 1; i <= r; i++) {
			if (nums[i] > nums[ma_idx]) {
				ma_idx = i;
			}
		}
		TreeNode root = new TreeNode(nums[ma_idx]);
		root.left = constructHelper(nums, l, ma_idx - 1);
		root.right = constructHelper(nums, ma_idx + 1, r);
		return root;
	}

}