package test;

import java.util.Arrays;

public class W001_MergeSortedTwoArray {
	
	/**
	 *  88. Merge Sorted Array
	 *  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	 *  
	 *  Note:
	 *  
	 *  The number of elements initialized in nums1 and nums2 are m and n respectively.
	 *  You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
	 *  Example:
	 *  
	 *  Input:
	 *  nums1 = [1,2,3,0,0,0], m = 3
	 *  nums2 = [2,5,6],       n = 3
	 *  
	 *  Output: [1,2,2,3,5,6]
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;
		while(i >= 0 && j >= 0){
			nums1[index--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
		}
		while(j >= 0){
			nums1[index--] = nums2[j--];
		}
	}
	
	public static void main(String[] args) {
		int [] nums1 = {1,2,3,0,0,0};
		int [] nums2 = {2,5,6};
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
		
		
		int [] nums11 = {1,2,3};
		int [] nums22 = {2,5,6};
		System.out.println(Arrays.toString(mergeTwoSortedArray(nums11,nums22)));
	}
	
	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
		if(arr1 == null){
			return arr2;
		}
		if(arr2 == null){
			return arr1;
		}
		int len1 = arr1.length;
		int len2 = arr2.length;
		int i = 0;
		int j = 0;
		int index = 0;
		
		int [] res = new int[len1 + len2];
		while(i < len1 && j < len2){
			res[index++] = (arr1[i] < arr2[j] ? arr1[i++] : arr2[j++]);
		}
		while(i < len1){
			res[index++] = arr1[i++];
		}
		while(j < len2){
			res[index++] = arr2[j++];
		}
		return res;
	}


}
