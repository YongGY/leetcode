package a1_array.sort;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 * @author William
 *
 */
public class A088_MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}

		for (int k2 = 0; k2 < nums1.length; k2++) {
			System.out.println(nums1[k2]);
		}
	}

	public static void main(String[] args) {
		merge(new int[] { 5, 7, 9, 0, 0, 0, 0 }, 3, new int[] { 3, 4, 8, 11 }, 4);
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
	}
}
