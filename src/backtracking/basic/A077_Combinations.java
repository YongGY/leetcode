package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * @author William
 *
 */
public class A077_Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(0, n, k, new ArrayList<>(), res);
		return res;
	}

	public void dfs(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == k) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < n; i++) {
			list.add(i + 1);
			dfs(i + 1, n, k, list, res);
			list.remove(list.size() - 1);
		}
	}

 	public static void main(String[] args) {

	}
}
