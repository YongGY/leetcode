package easy1_199;

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
public class E020_ValidParentheses {

	public static boolean isValid(String s) {
		if(s == null || s.length() < 2) return false;
		// 用stack来检查  
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			// 如果遇到前括号就压入栈  
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.size() == 0)
					return false;
				char top = stack.pop();
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
		return stack.size() == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("([]{})"));
		System.out.println(isValid("([{}])"));
		System.out.println(isValid("([)]"));
	}

}
