package easy1_199;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [_ n/2 _]times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 */
public class E169_MajorityElement {

	/**
	 * 哈希表法 复杂度: 时间 O(N) 空间 O(N) 在遍历数组的过程中，用一个哈希表记录每个数出现过的次数，如果该次数大于一半，则说明是众数。
	 */
	public static int majorityElement(int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int val = 0;
		for (int n : nums) {
			val = n;
			if (map.get(val) == null) {
				map.put(val, 1);
			} else {
				map.put(val, map.get(val) + 1);
			}

			if (map.get(val) > nums.length / 2) {
				break;
			}
		}
		return val;
	}

	/**
	 * 
	 * 投票法 复杂度 : 时间 O(N) 空间 O(1) 思路 记录一个candidate变量，还有一个counter变量，开始遍历数组。
	 * 如果新数和candidate一样，那么counter加上1，否则的话，如果counter不是0，则counter减去1，如果counter已经是0，则将candidate更新为这个新的数。
	 * 因为每一对不一样的数都会互相消去，最后留下来的candidate就是众数。
	 * 
	 */
	public int majorityElement01(int[] nums) {
		int candidate = nums[0], cnt = 0;
		for (int i = 1; i < nums.length; i++) {
			if (candidate == nums[i]) {
				cnt++;
			} else if (cnt == 0) {
				candidate = nums[i];
			} else {
				cnt--;
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 3, 4 }));
	}

}
