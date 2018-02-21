package easy200_399;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in
 * both arrays.
 * 
 * The result can be in any order.
 * 
 * Follow up: What if the given array is already sorted? How would you optimize
 * your algorithm?
 * 
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * 
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 */

public class E350_IntersectionOfTwoArraysII {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int k1 : nums1) {
			if (map.containsKey(k1)) {
				map.put(k1, map.get(k1) + 1);
			} else {
				map.put(k1, 1);
			}
		}
		
		for (int k2 : nums2) {
			if(map.containsKey(k2) && map.get(k2) > 0) {
				list.add(k2);
				map.put(k2, map.get(k2)-1);
			}
		}
		
 		int [] arr = new int[list.size()];
 		for (int i = 0; i < list.size(); i++) {
 			arr[i] = list.get(i);
 			System.err.println(arr[i]);
		}
 		return arr;

	}

	public static void main(String[] args) {
		System.out.println(intersect(new int[] {1, 2, 2, 1}, new int[] { 2, 2}));
	}
}
