package easy1_100;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author yongguo
 *
 */
public class E20_ValidParentheses {

	public static boolean isValid(String s) {
		Stack<Character> parentheses = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				parentheses.push(s.charAt(i));
			} else {
				if (parentheses.size() == 0)
					return false;
				char top = parentheses.pop();
				if (s.charAt(i) == ')') {
					if (top != '(')
						return false;
				} else if (s.charAt(i) == '}') {
					if (top != '{')
						return false;
				} else if (s.charAt(i) == ']') {
					if (top != '[')
						return false;
				}
			}
		}
		return parentheses.size() == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("([]{})"));
		System.out.println(isValid("([{}])"));
	}

}
