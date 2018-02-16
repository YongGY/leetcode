package easy200_299;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 */

public class E217_ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;

			}
		}
		return false;

	}
}
