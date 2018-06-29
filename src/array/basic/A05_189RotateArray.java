package array.basic;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. 
 * 
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * 翻转前n - k元素，翻转剩下的k个元素，最后翻转全部元素。O(n). Space complexity: O(1)
 * @author William
 *
 */
public class A05_189RotateArray {
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);  // 对整个数组翻转
		reverse(nums, 0, k - 1);			// 对下标0~k-1的数组翻转
		reverse(nums, k, nums.length - 1);	// 对下标k~len-1的数组翻转
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
	
}
