package math.seldom;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 *
 * @author William
 *
 */
public class A231_PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		int oneBitCount = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				oneBitCount++;
			}
			n = n >> 1;
		}
		return oneBitCount == 1;
	}
	
	public static boolean isPowerOfTwo1(int n) {
		return n > 0 && (n & (n-1)) == 0;
	}

	public static void main(String[] args) {
	    System.out.println(isPowerOfTwo(16));
	    System.out.println(isPowerOfTwo1(16));
	}

}
