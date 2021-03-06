package a8_binary_search;

/**
 * 
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * @author William
 *
 */
public class A162_FindPeakElement {

	/**
	 * 题目中已经说明，最左端和最右端元素均无限小，中间元素比两侧都要大，那么本题中一定存在一个峰元素。
	 * 所以不管中间有多少波峰，只要找到峰元素，我们只需找到刚刚开始下降而未下降的位置。
	 *
	 * 采用二分查找，查出这样一个位置即可.
	 * 我们知道二分查找要比较的是 target 元素，本题的 target 元素是 mid 的后一个元素，即 nums[mid] 与 nums[mid+1] 进行比较
	 */

	/**
	 *
	 * 另一种方法是使用二分查找法解决问题。这个方法利用了题目中的如下性质：
	 *
	 * 1）最左边的元素，它“更左边”的元素比它小（负无穷），我们认为它是一个增长的方向
	 *
	 * 2）最右边的元素，它“更右边”的元素比它小（也是负无穷），我们认为它是一个下降的方向
	 *
	 * 根据这两点我们可以判断：最左边和最右边的元素围成的区域内，必有至少一个顶点
	 *
	 * 现在我们找到中点 nums[mid]，将它与 nums[mid + 1] 作比较，如果前者较小，则方向是增长，与最左边的元素是一致的，就把左边界挪到mid+1的位置；否则与最右边的元素一致，将右边界挪到mid的位置。
	 *
	 * 这个方法的原理就是当左边界方向为“增长”，右边界方向为“下降”时，二者围出的区域必有一个顶点。
	 */
	public int findPeakElement(int[] nums) {

		if (nums == null) {
			return -1;
		} else if (nums.length == 0) {
			return -1;
		} else if (nums.length == 1) {
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public int findPeakElement1(int[] nums) {
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] < nums[i - 1]) {
				return i - 1;
			}
		}
		return nums.length - 1;
	}


 	public static void main(String[] args) {
 		
	}
}
