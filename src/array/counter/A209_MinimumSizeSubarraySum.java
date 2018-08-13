package array.counter;

/**
 * TGiven an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * Example: 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 * 
 * @author William
 * 
 * https://www.jianshu.com/p/42ec26e2e20a
 *
 */
public class A209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int from = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				minLen = Math.min(minLen, i - from + 1);
				sum -= nums[from++];
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
