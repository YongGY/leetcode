package a2_string.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author William
 *
 *
 */
public class A022_GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		dfs(result, 0, 0, "", n);
		return result;
	}

	public static void dfs(List<String> result, int left, int right, String s, int n) {
		if (right == n) {
			result.add(s);
		} else {
			if (left < n) {
				dfs(result,left + 1, right, s + "(", n);
			}
			if (right < left) {
				dfs(result,left, right + 1, s + ")", n);
			}
		}
	}
	
//	public static List<String> generateParenthesis(int n) {
//		List<String> result = new ArrayList<String>();
//		dfs(result, "", n, n);
//		return result;
//	}
//
//	/*
//	 * left and right represents the remaining number of ( and ) that need to be added. 
//	 * When left > right, there are more ")" placed than "(".
//	 * Such cases are wrong and the method stops.
//	 */
//	public static void dfs(List<String> result, String s, int left, int right) {
//		if (left > right)
//			return;
//
//		if (left == 0 && right == 0) {
//			result.add(s);
//			return;
//		}
//
//		if (left > 0) {
//			dfs(result, s + "(", left - 1, right);
//		}
//
//		if (right > 0) {
//			dfs(result, s + ")", left, right - 1);
//		}
//	}
//	
 	public static void main(String[] args) {
 		System.out.println(generateParenthesis(3));
	}
// 	
//// 	思路： 
//// 	use dfs, every point, it has two options '(', ')'. 
//// 	We have n left bracket '(', n right bracket ')',    
////   - when both  left and right are used up, we add to result.
////   - Watch return cases! if left > right, no valid answer. eg: )(())(
////   Also we can't have > n left or right bracket
////	 Complexity: Time O(2^n)  Space O(n)
//
//	public List<String> generateParenthesis1(int n) {
//		List<String> res = new ArrayList<String>();
//		dfs(new StringBuilder(), n, n, res);
//		return res;
//	}
//
//	public void dfs(StringBuilder path, int left, int right, List<String> res) {
//		int len = path.length();
//		if (left > right || left < 0 || right < 0) {
//			return;
//		}
//		if (left == 0 && right == 0) {
//			res.add(path.toString());
//			return;
//		}
//		dfs(path.append("("), left - 1, right, res);
//		path.setLength(len);
//		dfs(path.append(")"), left, right - 1, res);
//		path.setLength(len);
//	}
}
