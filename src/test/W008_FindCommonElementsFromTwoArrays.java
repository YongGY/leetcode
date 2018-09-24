package test;

import java.util.Arrays;
import java.util.HashSet;

public class W008_FindCommonElementsFromTwoArrays {

	public static void findCommonElements(int[] a, int[] b) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					set.add(a[i]);
				}
			}
		}
		System.out.println(set); // OUTPUT : [THREE, FOUR, FIVE]
	}

	public static void findCommonElements2(int[] a, int[] b) {

		Integer[] i1 = { 1, 2, 3, 4, 5, 4 };

		Integer[] i2 = { 3, 4, 5, 6, 7, 4 };

		HashSet<Integer> set1 = new HashSet<>(Arrays.asList(i1));

		HashSet<Integer> set2 = new HashSet<>(Arrays.asList(i2));

		set1.retainAll(set2);

		System.out.println(set1); // Output : [3, 4, 5]
	}

}
