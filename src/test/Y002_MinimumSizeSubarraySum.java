package test;

public class Y002_MinimumSizeSubarraySum {

	/**
	 *  209. Minimum Size Subarray Sum
	 * 
		Given an unsorted array and a target, 
		return the minimum lenght of continuous subarray whose sum is greater than or equal to target.
		
		e.g. [1,2,3,1,4,3], target = 7, return 2, because the minimum lenght of continuous subarray is [4,3]
	 * 
	 */

	//  https://www.jianshu.com/p/42ec26e2e20a
	public int minSubArrayLen(int[] nums, int target) {
		int sum = 0;
		int from = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				minLen = Math.min(minLen, i - from + 1);
				sum -= nums[from++];
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	

	public static void main(String[] args) {

		Y002_MinimumSizeSubarraySum mbs = new Y002_MinimumSizeSubarraySum();
		System.out.println(mbs.minSubArrayLen(new int[]{1,2,3,1,4,3}, 7));
	}

}
