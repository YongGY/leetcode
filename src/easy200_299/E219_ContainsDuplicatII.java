package easy200_299;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 */

public class E219_ContainsDuplicatII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums.length <= 1) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) != null && i - map.get(nums[i]) <= k) {
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] {-1,-1},1));
	}
}
