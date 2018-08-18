package a8_binary_search;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * @author William
 *
 */
public class A034_SearchForARange {

	public static int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				if (nums[left] == target && nums[right] == target) {
					return new int[]{left, right};
				} else if (nums[left] != target && nums[right] != target) {
					left++;
					right--;
				} else if (nums[left] != target) {
					left++;
				} else {
					right--;
				}
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[]{-1, -1};
	}

 	public static void main(String[] args) {
 		System.out.println(Arrays.toString( searchRange(new int[]{5,7,7,8,8,10},2 )));
	}
}
