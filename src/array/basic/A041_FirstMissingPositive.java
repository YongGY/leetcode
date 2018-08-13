package array.basic;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 * @author William
 *
 */

public class A041_FirstMissingPositive {

	/**
	 * 无序数组的题目如果要O(n)解法往往要用到hash table，但这题要求constant space。
	 * 所以可以用数组本身作为一个"hash table"：A[0] = 1, A[1] = 2, .... A[n-1] = n。
	 * 目标是尽可能将数字i放到数组第i-1个位置。
	 *
	 * 桶排序思想
	 * 扫描数组中每个数：
	 * 1. 如果A[i]<1或者A[i]>n。说明A[i]一定不是first missing positive。跳过
	 * 2. 如果A[i] = i+1，说明A[i]已经在正确的位置，跳过
	 * 3. 如果A[i]!=i+1，且0<A[i]<=n，应当将A[i]放到A[A[i]-1]的位置，所以可以交换两数。
	 * 这里注意，当A[i] = A[A[i]-1]时会陷入死循环。这种情况下直接跳过。
	 *
	 *
	 * 利用桶排序的思想，交换数组元素，使得数组中第i位存放的数值为(i+1)，
	 * 即当A[i]!=i+1时，交换A[i]和A[A[i]-1],直到没法交换为止，什么情况才算是没法交换？
	 * 当A[i]<=0 或 A[i]>n 时，A[i]-1就超出了数组边界，此时没法交换，当A[i]==A[A[i]-1]时，不用交换，也不能交换，否则造成程序死循环。
	 * 最后再判断数组中的一个A[i]不等于i+1的，返回i+1。
	 *
	 */

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		int i = 0;
		while (i < n) {
			if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i]= temp;
			} else {
				i++;
			}
		}

		for (int j = 0; j < n; j++) {
			if (nums[j] != j + 1) {
				return j + 1;
			}
		}
		return n + 1;
	}

	public static void main(String[] args) {
		firstMissingPositive(new int[] {3,4,-1,1});
	}
}
