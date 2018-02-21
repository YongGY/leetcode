package easy200_399;



/**
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 */

public class E326_PowerOfThree {

	public boolean isPowerOfThree(int n) {
		while (n / 3 >= 1) {
			if (n % 3 != 1) {
				return false;
			}
			n = n / 3;
		}
		return n == 1;
	}
	
	public static void main(String[] args) {
		
	}
}
