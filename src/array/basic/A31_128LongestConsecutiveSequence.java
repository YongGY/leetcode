package array.basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * 
 * @author William
 *
 */
public class A31_128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int count = 0;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int c = 0;
				while (set.contains(num + 1)) {
					c++;
				}
				count = Math.max(count, c);
			}
		}
		return count;

	}
}
