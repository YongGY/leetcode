package easy1_199;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author William
 * 
 * 
 *         这道题的几个点，
 *         1.alphanumeric characters and ignoring cases，字母和数字，忽略大小写。
 *         2.就是考虑空字符串是否为回文，这里是认为空字符串是回文。
 *         3.忽略大小写，所以就统一为大写。
 *         4.判断当前检查字符是否符合范围，否则大小指针挪动。
 *         5.如果发现有大小指针指向的值有不同的，就返回false，否则，继续检查。最后返回true。
 */
public class E125_ValidPalindrome {
	
	public static boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return true;
		}
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}else if(!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}else if(s.charAt(left) != s.charAt(right)) {
				return false;
			}else {
				left++;
				right--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
 