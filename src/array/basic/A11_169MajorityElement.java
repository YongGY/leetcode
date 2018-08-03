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
 * @author William
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

	/**
	 * 再介绍两个O(n)时间O(1)空间的方法：
	 *
	 * 1. 投票算法，因为符合的众数总是存在。
	 * 所以没出现一对不一样的就可以忽视这一对。
	 * 我们可以用计数表示，来一个数字，如果和candidate相同那么count++，否则count--，如果count为零了，那么candidate就是下一个数。
	 * 最后candidate就是众数了
	 */

	public int majorityElement1(int[] num) {
		int candidate = num[0]; // 用于记录候选元素，假设第一个是候选元素
		int count = 1; // 用于抵消数的个数

		for (int i = 1; i < num.length; i++) { // 从第二个元素开始到最后一个元素
			if (candidate == num[i]) { // 如果两个数相同就不能抵消
				count++; // 用于抵消的数据加1
			} else {
				if (count > 0) { // 如果不相同，并且有可以抵消的数
					count--; // 进行数据抵消
				} else { // 如果不相同，并且没有可以抵消的数
					candidate = num[i]; // 记录最后不可以抵消的数
				}
			}
		}
		return candidate;
	}
}
