package a2_string.palindrome;

/**
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Example 1:
 * Input: 121
 * Output: true
 * 
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 * 
 * 
 * @author William
 *
 */
public class A009_PalindromeNumber {
	
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int temp = x;
		int k = 0;
		while (x > 0) {
			k = k * 10 + x % 10;
			x = x / 10;
		}
		return temp == k;
	}
	
 	public static void main(String[] args) {
 		System.out.println(isPalindrome(121));
 		System.out.println(isPalindrome(-121));
 		System.out.println(isPalindrome(10));
 		System.out.println(isPalindrome(0));
	}
}
