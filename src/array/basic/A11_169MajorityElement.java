package array.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than |_n/2_| times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * @author Willam
 *
 */
public class A11_169MajorityElement {
	public int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		Map<Integer, Integer> map = new HashMap<>();
		int val = -1;
		for (int n : nums) {
			if (map.get(val) == null) {
				map.put(val, 1);
			} else {
				map.put(val, map.get(val) + 1);
			}
			if (map.get(val) > nums.length / 2) {
				val = n;
				break;
			}
		}
		return val;
	}
	
	public int majorityElement1(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		int candidate = nums[0];
		int counter = 0;
		for(int i=1; i<nums.length; i++) {
			if(candidate == nums[i]) {
				counter++;
			}else if(counter == 0) {
				candidate = nums[i];
			}else {
				counter--;
			}
		}
		return candidate;
	}
}
