package array.counter;

/**
 * Given an integer array nums, find the contiguous subarray 
 * within an array (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * @author William
 *
 */
public class A07_152MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int max = nums[0];
		int min = nums[0];
		int productMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
			productMax = Math.max(productMax, max);
		}
		return productMax;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{2,3,-2,4}));
		System.out.println(maxProduct(new int[]{-2,0,-1}));
		System.out.println(maxProduct(new int[]{-1,2,-3,2}));
	}
}
