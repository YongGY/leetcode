package array.counter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up:
 * Can you do it in O(n) time?
 * 
 * 
 * 
 * Solution Explanation
 * This problem is very similar to rest of the subarray sum problems. 
 * The initial intution is to find the sum of all numbers at every index i, if it matches with 'K',
 * store the index in max, keep updating it if and when there is a new index whose sum equals to K.
 * 
 * It works great, but until you realize that there may be an 'i' greater than zero, and another index 'j' where,
 * 
 *    sum(j) - sum(i) = K
 *    
 * To find a potential value like this, we can store the values in a map and retrieve, every time when the above condition matches.
 * 
 * 
 * Time Complexity
 * We traverse through the whole array once and caclulate sum and max index, so the time complexity is O(n), space complexity is O(n) since we use a map.
 * @author William
 *
 */
public class A04_325MaximumSizeSubarraySumEqualsK {
	
	public static int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				max = Math.max(max, i + 1);
			}
			// You can store either sum or sum-k, we can use sum-k because when it's 0, we
			// want to use the index value
			int diff = sum - k;
			if (!map.containsKey(diff)) {
				map.put(diff, i);
			} else {
				max = Math.max(max, i - map.get(diff));
			}
		}

		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,-3,3,-1,2,4};
		System.out.println(maxSubArrayLen(nums,3));
	}
}
