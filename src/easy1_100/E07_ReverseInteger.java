package easy1_100;

/**
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 * 
 * @author yongguo
 *
 */
public class E07_ReverseInteger {

	public static int reverse(int x) {
		int left = 0; long newnum = 0;
		
		while(x != 0){
			left = x % 10;
			newnum = newnum * 10 + left;
			x = x / 10;
		}
		
		if(newnum > Integer.MAX_VALUE || newnum < Integer.MIN_VALUE){
			return 0;
		}else{
			return (int)newnum;
		}

		
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

}
