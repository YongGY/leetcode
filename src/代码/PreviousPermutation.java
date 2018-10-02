package fb;

import java.util.Arrays;

public class PreviousPermutation {

	/**
	 * Next Permutation
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


    Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i].
    So, elements from num[i] to num[n-1] is reversely sorted.
    To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount,
    We have to make the highest changed position as high as possible.
    Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted.
    So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1].
    For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7.
    The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1]
	 */
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return;
		}
		int index = n - 1;
		while (index > 0) {
			if (nums[index - 1] < nums[index]) {
				break;
			}
			index--;
		}
		if (index == 0) {
			reverse(nums, 0, n - 1);
			return;
		}
		int val = nums[index - 1];
		int j = n - 1;
		while (j >= index) {
			if (nums[j] > val) {
				break;
			}
			j--;
		}
		swap(nums, j, index - 1);
		reverse(nums, index, n - 1);
	}

	/**
1,3,2 → 1,2,3
1,2,3 → 3,2,1
1,5,1 → 1,1,5

    Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] > num[i].
    So, elements from num[i] to num[n-1] is sorted.
    To find the next permutation, we have to swap some numbers at different positions, to minimize the decreased amount,
    we have to make the highest changed position as high as possible. Notice that index larger than or equal to i is not possible as num[i,n-1] is sorted.
    So, we want to decrease the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is smaller than num[i-1].
    For example, original number is 122543311, we want to swap the '2' at position 2 with '1' at position 7.
    The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1]
	 */
	public void previousPermutation(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return;
		}
		int index = n - 1;
		while (index > 0) {
			if (nums[index - 1] > nums[index]) {
				break;
			}
			index--;
		}
		if (index == 0) {
			reverse(nums, 0, n - 1);
			return;
		}
		int val = nums[index - 1];
		int j = n - 1;
		while (j >= index) {
			if (nums[j] < val) {
				break;
			}
			j--;
		}
		swap(nums, j, index - 1);
		reverse(nums, index, n - 1);
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i++] = nums[j];
			nums[j--] = tmp;
		}
	}

	public static void main(String[] args) {
		PreviousPermutation p = new PreviousPermutation();
		int[] nums = new int[] { 1, 2, 1, 5, 4, 3, 3, 2, 1 };
		p.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		p.previousPermutation(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		p.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		p.previousPermutation(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		p.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		p.previousPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
