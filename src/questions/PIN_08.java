package questions;

import java.util.ArrayList;
import java.util.List;

public class PIN_08 {
	// merge 2 sorted arrays, Find subset of array equal to sum.

	

	// A Java program to count all subsets with given sum. 
 
 
	// dp[i][j] is going to store true if sum j is
	// possible with array elements from 0 to i.
	static boolean[][] dp;

 
	// A recursive function to print all subsets with the
	// help of dp[][]. Vector p[] stores current subset.
	static void printSubsetsRec(int arr[], int i, int sum, List<Integer> p) {
		// If we reached end and sum is non-zero. We print
		// p[] only if arr[0] is equal to sun OR dp[0][sum]
		// is true.
		if (i == 0 && sum != 0 && dp[0][sum]) {
			p.add(arr[i]);
 			p.clear();
			return;
		}

		// If sum becomes 0
		if (i == 0 && sum == 0) {
 			p.clear();
			return;
		}

		// If given sum can be achieved after ignoring
		// current element.
		if (dp[i - 1][sum]) {
			// Create a new vector to store path
			List<Integer> b = new ArrayList<>();
			b.addAll(p);
			printSubsetsRec(arr, i - 1, sum, b);
		}

		// If given sum can be achieved after considering
		// current element.
		if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
			p.add(arr[i]);
			printSubsetsRec(arr, i - 1, sum - arr[i], p);
		}
	}
 
	// Driver Program to test above functions
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		int sum = 10;
		printAllSubsets(arr, n, sum);
	}
}
// This code is contributed by Sumit Ghosh

}
