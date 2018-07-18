package math.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 * @author William
 *
 */
public class A01_001TwoSum {

	public static int[] twoSum(int[] nums, int target) {
 		if (nums == null || nums.length < 2) {
			return null;
		}
		int [] res = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i< nums.length; i++){
			if(map.get(target - nums[i]) != null){
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i],i);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
	}
}
