package array.basic;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
 * 
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * 
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author William
 *
 */
public class A33_287FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int min = 0, max = nums.length - 1;
		while (min <= max) {
			// 找到中间那个数
			int mid = min + (max - min) / 2;
			int cnt = 0;
			// 计算总数组中有多少个数小于等于中间数
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid) {
					cnt++;
				}
			}
			// 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
			if (cnt > mid) {
				max = mid - 1;
				// 否则后半部分必有重复
			} else {
				min = mid + 1;
			}
		}
		return min;
	}
}
