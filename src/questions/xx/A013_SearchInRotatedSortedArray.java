package questions.xx;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * @author William
 *
 */
public class A013_SearchInRotatedSortedArray {


	/**
	 * 问题的大意是说，把一个升序的数组以某一个数为中心”旋转”以后得到一个数组，在这个数组中查找一个数，如果能查找到，就返回它的下标，如果不能查找到，就返回-1。 　　
	 * 一开始我没怎么理解这个“旋转”的含义，其实就是说，选定一个数，然后把整一个数组循环左移(右移也行)到这个数作为第一个，把左移溢出的数放在数组右边。 　　
	 * 比如[0,1,2,4,5,6,7]，假设我们选择的数是4,那么“旋转的”过程如下:
	 *
	 * 	->[1,2,4,5,6,7,0] //把0循环左移，补到最右边
	 * 	->[2,4,5,6,7,0,1] //把1循环左移，补到0的右边
	 * 	->[4,5,6,7,0,1,2] //把2循环左移，补到1的右边,这时候4是第一位，结束。
	 */

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (right - left) / 2 + left;

			if (target == nums[mid]) {
				return mid;
			}

			if (target >= nums[0] && nums[mid] < nums[0]) {//要找的数比nums[0]大，但是nums[mid]又比nums[0]小
				right = mid - 1;
			} else if (target < nums[0] && nums[mid] >= nums[0]) {//要找的数比nums[0]小(比如上面的2)但是nums[mid]又比nums[0]大，比如上面的7
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
 		System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
	}
}
