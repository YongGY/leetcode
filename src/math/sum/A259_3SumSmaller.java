package math.sum;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2.
 *
 * Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Follow up:
 * Could you solve it in O(n2) runtime?
 *
 * @author William
 *
 */
public class A259_3SumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum < target) {
					// all right in (left, right] will also satisfy the condition
					count += right - left;//eg [-2,0,1,3] 4,so -2,0,3满足，-2,0,1也满足
					left++;
				} else {
					right--;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {

	}
}
