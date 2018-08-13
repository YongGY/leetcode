package math.basic;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Returns: True
 *
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * @author William
 *
 */
public class A367_ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		long left = 0 ;
		long right = num;
		while(left <= right){
			long mid = (left + right) / 2;
			if(mid * mid == num){
				return true;
			}
			if(mid * mid < num){
				left = mid + 1;
			}else {
				right = mid -1;
			}
		}
		return false;
	}

	public static boolean isPerfectSquare2(int num) {
		for(int i = 1;num > 0;i+=2)
			num -= i;
		return 0 == num;
	}
 	public static void main(String[] args) {
 		System.out.println(isPerfectSquare(4));
 		System.out.println(isPerfectSquare2(4));

	}
}
