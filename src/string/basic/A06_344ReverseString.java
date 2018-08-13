package string.basic;

/**
 * 
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 * @author William
 *
 */
public class A06_344ReverseString {
	
	public static String reverseString(String s) {
		if (s == null || s.length() == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static String reverseString1(String s) {
		String res = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			res += s.charAt(i);
		}
		return res;
	}
	
 	public static void main(String[] args) {
		System.out.println(reverseString1(null));
	}
}
