package difficulty.easy1_199;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author yongguo
 *
 */
public class E009_PalindromeNumber {

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x == 0) {
			return true;
		}
		int temp = x;
		int newnum = 0;
		while (x != 0) {
			newnum = newnum * 10 + x % 10;
 			x = x / 10;
		}
		if (temp == newnum) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(10101));
	}

}
