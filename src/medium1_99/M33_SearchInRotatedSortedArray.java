package medium1_99;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author William
 * 
 * 
 * 一个由小到大有序排列的数组被分为两个子数组，这两个子数组调换前后顺序生成一个新数组。在新数组中找到目标值并返回下标
 *
 * 1.如果target比A[mid]值要小
 * 2.      如果A[mid]右边有序（A[mid]<A[high])
 * 3.            那么target肯定不在右边（target比右边的都得小），在左边找
 * 4.      如果A[mid]左边有序
 * 5.            那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
 * 6.如果target比A[mid]值要大
 * 7.     如果A[mid]左边有序（A[mid]>A[low]）
 * 8.           那么target肯定不在左边（target比左边的都得大），在右边找 
 * 9.     如果A[mid]右边有序
 * 10.           那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。
 *
 */
public class M33_SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			if (nums[mid] <= nums[right]) {
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(search(new int[] {0 ,1 ,2, 4, 5 ,6 ,7}, 3));
		search(new int[] {0 ,1 ,2, 4, 5 ,6 ,7}, 3);
	}

}
