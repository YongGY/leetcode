package a8_binary_search;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * @author William
 *
 */
public class A081_SearchInRotatedSortedArrayII {


	/**
	 * 暂且不考虑nums[mid] = nums[left]的情况，本题大致可以简化为上图两种情况，可能的情况划分出来，那么解决本题就比较容易了：
	 *
	 * 当 nums[mid] = nums[left] 时，这时由于很难判断 target 会落在哪，那么只能采取 left++
	 *
	 * 当 nums[mid] > nums[left] 时，这时可以分为两种情况，判断左半部比较简单
	 *
	 * 当 nums[mid] < nums[left] 时，这时可以分为两种情况，判断右半部比较简单
	 */
	public boolean search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return true;
			}
			if (nums[mid] == nums[left]) {
				left++;
			}else if (nums[mid] > nums[left]) {
				if (nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			} else {
				if (nums[right] >= target && nums[mid] < target) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
 		
	}
}
