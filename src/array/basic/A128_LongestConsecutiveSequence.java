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
public class A128_LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}
		int longest = 0;
		for (int n : set) {
			if (!set.contains(n - 1)) {
				int m = n + 1;
				while (set.contains(m)) {
					m++;
				}
				longest = Math.max(longest, m - n);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}
