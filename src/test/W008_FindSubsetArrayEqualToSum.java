package test;

import java.util.Arrays;

public class W008_FindSubsetArrayEqualToSum {
	// merge 2 sorted arrays, Find subset of array equal to sum.

	// 假如已merge 有序的了

	/**
	 * 列举数组中任意元素和为定值的组合
	 */
	// Arrays.sort(arr);
	static int[] flag = new int[100];
	static int index = 0;// 记录当前

	public static void numGroup(int[] arr, int start, int length, int sum) {
		if (sum == 0) {
			for (int j = 0; j < index; j++) {
				System.out.print(flag[j]+",");
			}
			System.out.println();
		} else {
			for (int i = start; i < length; i++) {
				flag[index++] = arr[i];
				numGroup(arr, i + 1, length - 1, sum - arr[i]);
			}
		}
		index--;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 7, 8, 9 };
		Arrays.sort(arr);
		int sum = 8;
		numGroup(arr, 0, arr.length, sum);
	}
	
}
