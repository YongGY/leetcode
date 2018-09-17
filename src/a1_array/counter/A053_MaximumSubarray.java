package a1_array.counter;

import java.util.Arrays;

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
public class A053_MaximumSubarray {

	public int maxSubArray1(int[] nums) {
		int max = nums[0];
		int sub = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sub = (sub + nums[i] > nums[i]) ? sub + nums[i] : nums[i];
			max = Math.max(max, sub);
		}
		return max;
	}
	
	
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
		System.out.println(Arrays.toString(sum));
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{1,2,-4,3,4,-1,4,5,-10}));
		
	}
	
	
}
