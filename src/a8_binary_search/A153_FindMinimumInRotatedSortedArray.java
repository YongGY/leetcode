package a8_binary_search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * @author William
 *
 */
public class A153_FindMinimumInRotatedSortedArray {

	//https://blog.csdn.net/Koala_Tree/article/details/78477304

	// loop invariant: 1. low < high
	//                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
	//                 3. minimum is between [low, high]
	// The proof that the loop will exit: after each iteration either the 'high' decreases
	// or the 'low' increases, so the interval [low, high] will always shrink.
	public int findMin1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {// the mininum is in the right part
				left = mid + 1;
			} else if (nums[mid] < nums[right]) { // the mininum is in the left part
				right = mid;
			}
		}
		return nums[left];
	}

 	public static void main(String[] args) {
 		
	}
}
