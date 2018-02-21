package easy200_399;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 */

public class E349_IntersectionOfTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> setReturn = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if(!set.add(nums2[i]) ) {
				setReturn.add(nums2[i]);
			}
		}
		int [] arr = new int[setReturn.size()];
 
		Iterator<Integer> it = setReturn.iterator();
		int n = 0;
		while (it.hasNext()) {
			arr[n++] = it.next();
		}
		return arr;

	}

	public static void main(String[] args) {
		System.out.println(intersection(new int[] {1, 2, 2, 1}, new int[] { 2, 2}));
	}
}
