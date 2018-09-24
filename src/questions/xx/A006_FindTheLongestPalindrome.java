package questions.xx;

public class A006_FindTheLongestPalindrome {

	public String findTheLongestPalindrome(String str) {
		if (str == null) {
			return null;
		}
		String longestPalindrome = String.valueOf(str.charAt(0));
		for (int i = 0; i < str.length() - 1; i++) {
			String renStr = findLongestPalindromeWithSpecifiedParameter(str, i, i);
			if (renStr.length() > longestPalindrome.length()) {
				longestPalindrome = renStr;
			}
			renStr = findLongestPalindromeWithSpecifiedParameter(str, i, i + 1);
			if (renStr.length() > longestPalindrome.length()) {
				longestPalindrome = renStr;
			}
		}
		return longestPalindrome;
	}

	public String findLongestPalindromeWithSpecifiedParameter(String str, int left, int right) {
		if (left > right)
			return null;

		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return str.substring(left + 1, right);
	}

	public static void main(String[] args) {
		A006_FindTheLongestPalindrome longestPalindrome = new A006_FindTheLongestPalindrome();
		System.out.println("Longest palindrome in abcmadamcbamadam is " + longestPalindrome.findTheLongestPalindrome("abc"));
		System.out.println("Longest palindrome in abcba is " + longestPalindrome.findTheLongestPalindrome("aabbcc"));
		System.out.println("Longest palindrome in abcba is " + longestPalindrome.findTheLongestPalindrome("abbaccd"));
		System.out.println("Longest palindrome in abcba is " + longestPalindrome.findTheLongestPalindrome("aba"));
	}
}