package array.basic;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * 
 * Given [1, 2, 3, 4, 5],
 * return true.
 * 
 * Given [5, 4, 3, 2, 1],
 * return false.
 * 
 * @author William
 * 
 * This problem can be converted to be finding if there is a sequence 
 * such that the_smallest_so_far < the_second_smallest_so_far < current. 
 * We use x, y and z to denote the 3 number respectively.
 * 
 * Iterate through the array, keep track the 2 min(so far) variables, initialize with Integer.MAX_VALUE to overwrite.
 * If there is any element greater than firstMin and secondMin. We find answer.
 *
 *
 */
public class A334_IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;
		int min = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min)
				min = num; // 如果min大于等于当前数字，则将当前数字赋给min
			else if (num <= mid)
				mid = num; // 如果min小于当前数字且mid大于等于当前数字，那么将当前数字赋给mid，一旦mid被更新了，说明一定会有一个数小于mid
			else
				return true; // 那么我们就成功的组成了一个长度为2的递增子序列，所以我们一旦遍历到比mid还大的数，我们直接返回ture
		}
		return false;
	}
}
