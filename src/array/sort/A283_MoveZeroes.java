package array.sort;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * @author William
 *
 */
public class A283_MoveZeroes {
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[k++] = nums[i];
			}
		}
		while (k < nums.length) {
			nums[k++] = 0;
		}

		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		moveZeroes(new int[]{0,1,0,3,12,0});
	}
}
