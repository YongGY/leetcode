package questions.xx;

public class A004_kthSmallestTwoSortedArrays {

	/**
	 * Find Kth smallest element in two sorted arrays
	 * 
	 * Complexity of algorithm to find Kth smallest element in union of two arrays is O(log(N+M)).
	 * 
	 * https://www.algorithmsandme.com/find-kth-smallest-element-in-two-sorted-arrays/
	 * 
	 */

	public static int findKthSmallestElement(int[] A, int[] B, int k) {

		int lenA = A.length;
		int lenB = B.length;

		if (lenA + lenB < k)
			return -1;

		int iMin = 0;
		int iMax = Integer.min(A.length, k - 1);

		int i = 0;
		int j = 0;

		while (iMin <= iMax) {
			i = (iMin + iMax) / 2;
			j = k - 1 - i; // because of zero based index
			if (B[j - 1] > A[i]) {
				// i is too small, must increase it
				iMin = i + 1;
			} else if (i > 0 && A[i - 1] > B[j]) {
				// i is too big, must decrease it
				iMax = i - 1;
			} else {
				// i is perfect
				return Integer.min(A[i], B[j]);
			}
		}
		return -1;
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Auxiliary Space : O(m + n)
	 */

	static int kth(int arr1[], int arr2[], int m, int n, int k) {
		int[] sorted1 = new int[m + n];
		int i = 0, j = 0, d = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				sorted1[d++] = arr1[i++];
			else
				sorted1[d++] = arr2[j++];
		}
		while (i < m)
			sorted1[d++] = arr1[i++];
		while (j < n)
			sorted1[d++] = arr2[j++];
		return sorted1[k - 1];
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6, 7, 8, 9, 11 };
		int[] b = { 1, 4, 6, 8, 12, 14, 15, 17 };

		int smallest = findKthSmallestElement(a, b, 3);
		System.out.println("Kth smallest element is : " + smallest);
	}

}
