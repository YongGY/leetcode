package a2_string.subsequence;

/**
 * 
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t. 
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 *  (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
 * and you want to check one by one to see if T has its subsequence. 
 * In this scenario, how would you change your code?
 * 
 * @author William
 *
 */
public class A392_IsSubsequence {

	/**
	 * 思路：
	 * 这道题最直接的思路就是遍历t，一个个按顺序检查s中的字符是否顺序出现了，如果一直到s的最后一个字符都出现了，而且是符合顺序的，那就返回true，否则返回false。
	 *
	 * 但是，这个做法没有用到题目中全是英文小写字母的说明。对于多个子序列检测的情况，同时检测，且多个S之间也需进行一定的比较。
	 *
	 */
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}

		int i = 0;
		for (int j = 0; j < t.length(); j++) {
			if (t.charAt(j) - s.charAt(i) == 0) {
				i++;
				if (i == s.length()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSubsequence1(String s, String t) {
		if (s == null || s.length() == 0) {
			return true;
		}

		if (t == null || t.length() == 0) {
			return false;
		}

		int i = t.indexOf(s.charAt(0), 0);

		if (i == -1) {
			return false;
		}

		for (int j = 1; j < s.length(); j++) {
			i = t.indexOf(s.charAt(j), i + 1);

			if (i == -1)
				return false;
		}

		return true;
	}


 	public static void main(String[] args) {
 		
	}
}
