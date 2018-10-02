package W.OOD;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K001_FindPairEqualToGivenNumberMain {

	public static void main(String[] args) {
		int array[] = { -40, -5, 1, 3, 6, 7, 8, 20 };
		findPairsWithSumEqualsToXBruteForce(array, 15);
		findPairsEqualsToX(array, 15);
		findPairsEqualsToXUsingHashing(array, 15);
	}

	public static void findPairsWithSumEqualsToXBruteForce(int arr[], int X) {
		if (arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempSum = arr[i] + arr[j];
				if (tempSum == X) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

	public static void findPairsEqualsToX(int arr[], int X) {
		int n = arr.length;
		if (n < 2) {
			return;
		}
		Arrays.sort(arr);
		int l = 0;
		int r = n - 1;
		while (l < r) {
			if (arr[l] + arr[r] == X) {
				System.out.println(arr[l] + " " + arr[r]);
				l++;
				r--;
			} else if (arr[l] + arr[r] < X) {
				l++;
			} else {
				r--;
			}
		}
	}

	public static void findPairsEqualsToXUsingHashing(int[] A, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(sum - A[i])) {
				System.out.println("Pair found at index (" + A[i] + " ," + A[map.get(sum - A[i])] + ") = " + sum);
			} else {
				map.put(A[i], i);
			}
		}
	}
}
