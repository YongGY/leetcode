package array.basic;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * 
 * Input: [1,2,0] Output: 3 Example 2:
 * 
 * Input: [3,4,-1,1] Output: 2 Example 3:
 * 
 * Input: [7,8,9,11,12] Output: 1
 * 
 * 把元素放入正确的位置，例如1放在A[0]，2放在A[1]... 
 * 
 * 桶排序思想，每次当A[i] != i的时候，将A[i]与A[A[i]]交换，直到无法交换位置。终止条件是 A[i]== A[A[i]]。
 * 
 * @author Willam
 *
 */
public class A06_041FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(Arrays.toString(nums));
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
	
	public static void main(String[] args) {
		firstMissingPositive(new int[] {3,4,-1,1});
	}
}
