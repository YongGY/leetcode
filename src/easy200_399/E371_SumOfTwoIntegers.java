package easy200_399;

/**
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 */

public class E371_SumOfTwoIntegers {

	public static int getSum(int a, int b) {
		while(a != 0 && b != 0){
			int c = a & b;
			a = a ^ b;
			b = c << 1;
 		}
		return a == 0 ? b : a;

	}
 
	public static void main(String[] args) {
		System.out.println(getSum(-2, -5));
	}
}
