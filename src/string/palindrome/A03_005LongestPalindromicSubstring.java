package string.palindrome;

/**
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * 
 * @author William
 *
 */
public class A03_005LongestPalindromicSubstring {

	/**
	 * https://segmentfault.com/a/1190000002991199
	 */
//	public static String longestPalindrome(String s) {
//		if (s.isEmpty()) {
//			return null;
//		}
//
//		if (s.length() == 1) {
//			return s;
//		}
//
//		String longest = s.substring(0, 1);
//		System.out.println(longest);
//		for (int i = 0; i < s.length(); i++) {
//			// get longest palindrome with center of i
//			String tmp = helper(s, i, i);  //回文子串是奇数的情况
//			if (tmp.length() > longest.length()) {
//				longest = tmp;
//			}
//
//			// get longest palindrome with center of i, i+1
//			tmp = helper(s, i, i + 1); //回文子串是偶数的情况
//			if (tmp.length() > longest.length()) {
//				longest = tmp;
//			}
//		}
//		return longest;
//	}
//
//	// Given a center, either one letter or two letter,
//	// Find longest palindrome
//	public static String helper(String s, int begin, int end) {
//		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
//			begin--;
//			end++;
//		}
//		return s.substring(begin + 1, end);
//	}

	public static void main(String[] args) {
// 		System.out.println(longestPalindrome("babad"));
 		System.out.println(longestPalindrome("cbbd") +"1111");
	}



	static String longest = "";

	public static String longestPalindrome(String s) {

		if (s.isEmpty()) {
			return null;
		}

		if (s.length() == 1) {
			return s;
		}

		for(int i = 0; i < s.length(); i++){
			//计算奇数子字符串
			helper(s, i, i);
			//计算偶数子字符串
			helper(s, i, i+1);
		}
		return longest;
	}

	private static void helper(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		// 截出当前最长的子串
		String currLongest = s.substring(left + 1, right);
		// 判断是否比全局最长还长
		if(currLongest.length() > longest.length()){
			longest = currLongest;
		}
	}



}
