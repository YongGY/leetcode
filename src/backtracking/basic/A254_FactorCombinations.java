package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 *
 * Examples:
 * input: 1
 * output:
 * []
 *
 * input: 37
 * output:
 * []
 *
 * input: 12
 * output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * input: 32
 * output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 * 
 * @author William
 *
 */
public class A254_FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n <= 1) {
			return res;
		}
		dfs(res, new ArrayList<>(), n, 2);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list, int n, int start) {
		for (int i = start; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && n / i >= i) {
				list.add(i);
				list.add(n / i);
				res.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
				dfs(res, list, n / i, i);
				list.remove(list.size() - 1);
			}
		}
	}



//	public List<List<Integer>> getFactors(int n) {
//		List<List<Integer>> res = new ArrayList<>();
//		if(n <= 3) return res;
//		dfs(n, res, new ArrayList<>(), -1);
//		return res;
//	}
//
//	public void dfs(int n, List<List<Integer>> res, List<Integer> path, int lower){
//		// 和一般combination不同的是，每一步都要导入到结果中。
//		if(lower != -1){
//			path.add(n);
//			res.add(new ArrayList<>(path));
//			path.remove(path.size()-1);
//		}
//
//		// lower 是为了解决重复分解的问题，比如12 = 2*2*3 = 3*2*2，但是后一个是重复的， 所以分解之后factor不能变小。
//		// upper 也是为了去重，12 = 3*4 = 4*3, 两个分解的解法是对称的，乘法对称的重点就是sqrt(n).
//		int upper = (int) Math.sqrt(n);
//		for(int i=Math.max(2, lower); i<= upper; i++){
//			if(n%i == 0){
//				path.add(i);
//				dfs(n/i, res, path, i);
//				path.remove(path.size()-1);
//			}
//		}
//	}



//	public List<List<Integer>> getFactors(int n) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		helper(result, new ArrayList<Integer>(), n, 2);
//		return result;
//	}
//
//	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
//		if (n <= 1) {
//			if (item.size() > 1) {
//				result.add(new ArrayList<Integer>(item));
//			}
//			return;
//		}
//
//		for (int i = start; i * i <= n; ++i) {
//			if (n % i == 0) {
//				item.add(i);
//				helper(result, item, n/i, i);
//				item.remove(item.size()-1);
//			}
//		}
//
//		int i = n;
//		item.add(i);
//		helper(result, item, 1, i);
//		item.remove(item.size()-1);
//	}

 	public static void main(String[] args) {
 		
	}
}
