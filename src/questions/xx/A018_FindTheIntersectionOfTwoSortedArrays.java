package questions.xx;

public class A018_FindTheIntersectionOfTwoSortedArrays {

	/**
	 * Find the intersection of 2 arrays A,B. Given A,B does not contain
	 * duplicates.
	 *
	 */
	int intersectionPoint = -1;
	int x;
	int y;

	public int intersection(int[] arrA, int[] arrB) {
		while (x < arrA.length && y < arrB.length) {
			if (arrA[x] > arrB[y])
				y++;
			else if (arrA[x] < arrB[y])
				x++;
			else {
				intersectionPoint = arrA[x];
				return intersectionPoint;
			}
		}
		return intersectionPoint;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] a = { 1, 2, 3, 6, 8, 10 };
		int[] b = { 4, 5, 6, 11, 15, 20 };
		A018_FindTheIntersectionOfTwoSortedArrays i = new A018_FindTheIntersectionOfTwoSortedArrays();
		System.out.println("Intersection point is : " + i.intersection(a, b));

	}
}
