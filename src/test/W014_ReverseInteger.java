package test;

/**
 * 007. Reverse a number without converting to string
 * 
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
public class W014_ReverseInteger {

	public static int reverse(int x) {
		int res = 0;
		 while(x != 0){
			 res = res * 10 + x % 10;
			 x = x / 10;
		 }
		 return res;
	}

	public static void main(String[] args) {
	    System.out.println(reverse(123));
	    System.out.println(reverse(-1234));
	    System.out.println(reverse(120));
	}
}
