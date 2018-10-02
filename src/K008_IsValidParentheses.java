import java.util.Stack;

public class K008_IsValidParentheses {

	public static boolean isValid(String str) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			//
			if (c != '(' && c != ')' && c != '[' && c != ']' && c != '{' && c != '}') {
				continue;
			}
			//
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else {
				if (stack.isEmpty() || stack.pop() != c) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("([]{})"));
		System.out.println(isValid("([{}])"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("]"));
	}
}
