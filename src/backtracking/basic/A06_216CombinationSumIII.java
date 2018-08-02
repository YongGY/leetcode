package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author William
 *
 */
public class A06_216CombinationSumIII {

	/**
	 * 思路： use backtracking to find all possible solutions.
	 * Complexity: Time O(9!) - total possibilities Space O(9) stack
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(n, k, 1, new ArrayList(), res);
		return res;
	}

	private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == k) {
			if (n == 0) {
				res.add(new ArrayList(list));
			}
			return;
		}
		for (int i = start; i <= 9; i++) {//digits from 1 to 9
			list.add(i);
			dfs(n - i, k, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}
	
 	public static void main(String[] args) {
 		
	}
}
