package easy1_199;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * 
 * 
 * 倒序存储 复杂度 时间 O(N+M) 空间 O(1)
 * 
 * 思路
 * 提示第一个数组的大小足以装两个数组,所以自然想到把两个数组都合并到第一个数组中,但是第一个数组前面都是有用的信息,如果直接从前面加,我们得将后面所有的数都位移。
 * 但是如果我们从后往前,合并到第一个数组的最后,则不用位移。
 * 
 * 注意: 将m和n都先减1,用m和n来代表下标,避免两个数组为空时抛出空指针异常。
 * 
 * @author William
 *
 */
public class E088_MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		m = m - 1;
		n = n - 1;
		int i = m + n + 1;
		while (m >= 0 || n >= 0) {
			if (m < 0) {
				nums1[i--] = nums2[n--];
			} else if (n < 0) {
				nums1[i--] = nums1[m--];
			} else {
				nums1[i--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
			}

		}
		for (int k2 = 0; k2 < nums1.length; k2++) {
			System.out.println(nums1[k2]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge(new int[] { 5, 7, 9, 0, 0, 0, 0, 0, 0 }, 3, new int[] { 3, 4, 8, 11 }, 4);
	}

}
