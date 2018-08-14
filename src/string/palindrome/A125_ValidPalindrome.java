package string.palindrome;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Example 2:
 * Input: "race a car"
 * Output: false
 * 
 * @author William
 *
 */
public class A125_ValidPalindrome {
	
    public static boolean isPalindrome(String s) {
 
		if (s.length() == 0) {
			return true;
		}
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (!isAlphanumeric(s.charAt(left))) {
				left++;
			} else if (!isAlphanumeric(s.charAt(right))) {
				right--;
			} else if (toLower(s.charAt(left)) != toLower(s.charAt(right))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
    }
    
    //Character.isLetterOrDigit(char c)
	public static boolean isAlphanumeric(char c) {
		if ('A' <= c && c <= 'Z')
			return true;
		else if ('a' <= c && c <= 'z')
			return true;
		else if ('0' <= c && c <= '9')
			return true;
		return false;
	}
	
	//s = s.toLowerCase(String s);
	public static char toLower(char c) {
		if ('A' <= c && c <= 'Z')
			return (char) ('a' + c - 'A');
		return c;
	}




	public static void main(String[] args) {

		System.out.println(isPalindrome("0P"));
	}

}
