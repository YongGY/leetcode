package questions.xx;

public class A018_FindTheIntersectionOfTwoSortedArrays {

	/**
	 * Find the intersection of 2 arrays A,B. Given A,B does not contain
	 * duplicates.
	 *
	 */
	int intersectionPoint = -1;
	int i;
	int j;

	public int intersection(int[] arrA, int[] arrB) {
		while (i < arrA.length && j < arrB.length) {
			if (arrA[i] > arrB[j])
				j++;
			else if (arrA[i] < arrB[j])
				i++;
			else {
				System.out.println(arrA[i]);
				intersectionPoint = arrA[i];
				i++;
				j++;
				//return intersectionPoint;
			}
		}
		return intersectionPoint;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] a = { 1, 2, 3, 6, 8, 10 };
		int[] b = { 4, 5, 6, 8, 15, 20 };
		A018_FindTheIntersectionOfTwoSortedArrays i = new A018_FindTheIntersectionOfTwoSortedArrays();
		System.out.println("Intersection point is : " + i.intersection(a, b));

	}
}
