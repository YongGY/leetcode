package easy1_99;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice. 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 =9, return [0, 1].
 * 
 * @author yongguo
 */
public class E01_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length < 2) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
	}

}
