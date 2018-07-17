package string.parentheses;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * @author William
 *
 */
public class A03_032LongestValidParentheses {
	
	// 使用栈，时间复杂度O(n)，空间复杂度O(n)
	public static int longestValidParentheses(String s) {
		// the position of the last ')'
		int maxLen = 0, last = -1;
		// keep track of the positions of non-matching '('s
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.empty()) {
					// no matching left
					last = i;
				} else {
					// find a matching pair
					stack.pop();
					if (stack.empty()) {
						maxLen = Math.max(maxLen, i - last);
					} else {
						maxLen = Math.max(maxLen, i - stack.peek());
					}
				}
			}
		}
		return maxLen;
	}
	
	
 	public static void main(String[] args) {
 		System.out.println(longestValidParentheses("(()"));
 		System.out.println(longestValidParentheses(")()())"));
 		System.out.println(longestValidParentheses("(())"));
	}
}
