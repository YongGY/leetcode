package math.basic;

/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 * @author William
 *
 */
public class A029_DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) {
			return 0;
		}
		boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		if (b > a) {
			return 0;
		}

		long sum = 0;
		long pow = 0;
		int result = 0;
		while (a >= b) {
			pow = 1;
			sum = b;
			while (sum + sum <= a) {
				sum += sum;
				pow += pow;
			}
			a -= sum;
			result += pow;
		}
		return isNeg ? -result : result;
	}


	public static void main(String[] args) {

	}
}
