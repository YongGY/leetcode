package google;

import java.util.*;

/**
 * N students {0, ..., N-1} participate in a marathon. - You are given A[N] and
 * A[i] = j means that student j finished just before student i - A[k] = -1
 * means that k is the first student. - No tie. List out the students in the
 * order in which they finished the marathon.
 * 
 * A[1] = 0 
 * A[0] = -1
	A[2] = 1

i/p: A [-1, 0, 1]
o/p: [0, 1, 2]
 */
public class Marathon {
	public static int[] findOrder(int[] A) {
		int n = A.length;
		int[] result = new int[n];
		Map<Integer, Integer> adjList = new HashMap<>();
		int cur = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == -1) {
				cur = i;
				continue;
			}
			adjList.put(A[i], i);
		}

		int count = -1;
		while (++count < n) {
			result[count] = cur;
			cur = adjList.getOrDefault(cur, -1);
		}

		return result;
	}

	public static int[] findOrder2(int[] A) {
		int n = A.length;
		int[] result = new int[n];
		int[] adjList = new int[n];
		Arrays.fill(adjList, -1);
		int cur = -1;
		for (int i = 0; i < n; i++) {
			if (A[i] == -1) {
				cur = i;
				continue;
			}
			adjList[A[i]] = i;
		}

		int count = -1;
		while (++count < n) {
			result[count] = cur;
			cur = adjList[cur];
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder2(new int[] {-1, 0, 1})));
	}

}
