package array.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of size n, find all elements that appear more than n/3 times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 * @author William
 *
 */
public class A229_MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) > nums.length / 3) {
				list.add(key);
			}
		}
		return list;
	}

	public static List<Integer> majorityElement1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int number1 = nums[0], number2 = nums[0];
		int count1 = 0, count2 = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1) {
				count1++;
			} else if (nums[i] == number2) {
				count2++;
			} else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1) {
				count1++;
			} else if (nums[i] == number2) {
				count2++;
			}
		}
		if (count1 > len / 3) {
			res.add(number1);
		}
		if (count2 > len / 3) {
			res.add(number2);
		}
		return res;
	}


    public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1}));
		System.out.println(majorityElement1(new int[] {1}));
	}
}
