package backtracking.basic;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * @author William
 *
 */
public class A031_NextPermutation {

	/**
	 * 			1,2,3 → 1,3,2
	 * 			3,2,1 → 1,2,3
	 * 			1,1,5 → 1,5,1
	 * 			12345->12354->12435->12453->12534
	 *
	 * 	http://cs-cjl.com/2016/09_22_leetcode_31_next_permutation
	 */

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) return;
		int len = nums.length;
		for (int i = len - 2; i >= 0; i--) {
			//应维持降序，就没空间改进了，直到找到打破规律变为升序的这个元素：这个元素之后没法改进了，
			// 所以当前这位就要替换成大一点的数：在后面元素里找刚刚比他大的（相当于进位到这个数（比当前大的最小数）了）
			if (nums[i] < nums[i + 1]) { //只要是升序，就说明有改进空间，通过和后面某元素交换
				for (int j = len - 1; j > i; j--) {
					if (nums[j] > nums[i]) {
						swap(nums, i, j);
						reverse(nums, i + 1, len - 1);  //把这个降序变为升序，才能让整体变小，成为真正的next permutation
						return;
					}
				}
			}
		}
		reverse(nums, 0, len - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}

	public static void main(String[] args) {
 		
	}
}
