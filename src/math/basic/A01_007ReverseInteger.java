package math.basic;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 *
 * @author William
 *
 */
public class A01_007ReverseInteger {

	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}

	public static void main(String[] args) {
	    System.out.println(reverse(123));
	    System.out.println(reverse(-123));
	    System.out.println(reverse(120));
	}
}
