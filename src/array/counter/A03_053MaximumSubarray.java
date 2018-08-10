package array.counter;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * @author William
 *
 */
public class A03_053MaximumSubarray {

	public int maxSubArray1(int[] nums) {
		int max = nums[0];
		int sub = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sub = (sub + nums[i] > nums[i]) ? sub + nums[i] : nums[i];
			max = Math.max(max, sub);
		}
		return max;
	}
}
