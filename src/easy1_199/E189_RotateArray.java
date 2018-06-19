package easy1_199;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 */

public class E189_RotateArray {

	public static void rotate(int[] nums, int k) {
		for (int i = 0; i < nums.length / 2; i++) {
			int nums_i = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = nums_i;
		}

		for (int i = 0; i < k / 2; i++) {
			int nums_i = nums[i];
			nums[i] = nums[k - 1 - i];
			nums[k - 1 - i] = nums_i;
		}
		
		for (int i = k; i < (nums.length - k) / 2 + k; i++) {
			int nums_i = nums[i];
			nums[i] = nums[nums.length - i + k - 1];
			nums[nums.length - i + k - 1] = nums_i;
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

	public static void main(String[] args) {
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
	}

}
