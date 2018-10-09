package questions.xx;

import java.util.HashSet;

public class A017_FindTheIntersectionOfTwoUnsortArrays {

	/**
	 * Find the intersection of 2 arrays A,B. Given A,B does not contain
	 * duplicates.
	 *
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i : nums1) {
			set1.add(i);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i : nums2) {
			if (set1.contains(i)) {
				set2.add(i);
			}
		}

		int[] result = new int[set2.size()];
		int i = 0;
		for (int n : set2) {
			result[i++] = n;
		}

		return result;
	}

}