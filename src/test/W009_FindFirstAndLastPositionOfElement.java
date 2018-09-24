package test;

import java.util.Arrays;

public class W009_FindFirstAndLastPositionOfElement {

	/**
	 * 34. Find First and Last Position of Element in Sorted Array
	 * 
	 * Given an array of integers nums sorted in ascending order, find the
	 * starting and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] 
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
	 * 
	 */
	
	public int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return res;
		}

		int index = searchRightIndex(nums, 0, nums.length - 1, target);
		if (index < 0 || nums[index] != target) {
			return res;
		}
		res[0] = searchLeftIndex(nums, 0, index, target);
		res[1] = index;
		return res;
	}

	public int searchRightIndex(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return right;
	}

	public int searchLeftIndex(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
 

	
	
	public static int[] findFirstAndLast(int[] nums, int target) {
		int[] res = { -1, -1 };

		if (nums.length == 0 || nums == null)
			return res;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (res[0] == -1) {
					res[0] = i;
				}
				res[1] = i;
			}
		}
		return res;
	}

	 

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int x = 2;
		findFirstAndLast(arr, x);
		
		W009_FindFirstAndLastPositionOfElement a = new W009_FindFirstAndLastPositionOfElement();
		
		System.out.println(Arrays.toString(a.searchRange(arr, x)));
	}

}