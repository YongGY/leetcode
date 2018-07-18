package difficulty.easy200_399;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1: Input: 16 Returns: True Example 2: Input: 14 Returns: False
 * 
 */

public class E367_ValidPerfectSquare {

	//Newton's method, close to O(1)
	public boolean isPerfectSquare(int num) {
		if (num < 1)
			return false;
		long t = num / 2 + 1;
		while (t * t > num) {
			t = (t + num / t) / 2;
		}
		return t * t == num;
	}

	//Binary-Search method, O(logn)
	public boolean isPerfectSquare01(int num) {
		if (num == 1)
			return true;
		long lo = 1;
		long hi = num / 2;

		long x = num;

		while (lo <= hi) {
			long mid = lo + (hi - lo) / 2;
			if (mid * mid < x)
				return true;
			else if (mid * mid < x)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return false;
	}

	public static void main(String[] args) {
	}
}
