package math.basic;

/**
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @author William
 *
 */
public class A067_AddBinary {

	public static String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;

		String ans = "";

		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			sum += (i >= 0) ? a.charAt(i) - '0' : 0;
			sum += (j >= 0) ? b.charAt(j) - '0' : 0;
			ans = (sum % 2) + ans;
			carry = sum / 2;
			i--;
			j--;
		}
		if (carry != 0) {
			ans = carry + ans;
		}
		return ans;
	}

 	public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
		System.out.println(addBinary("1010","1011"));
	}
}
