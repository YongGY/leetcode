package common;

import java.util.Arrays;

/**
 * 
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * @author William
 *
 */
public class A04_016_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int result = 0;
		int min = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = Math.abs(sum - target);
				if (diff == target) return sum;

				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
    
 	public static void main(String[] args) {
 		
	}
}
