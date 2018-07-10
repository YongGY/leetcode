package string.basic;

/**
 * 
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 * 
 * 
 * @author William
 *
 */
public class A07_151ReverseWordsInAString {
	
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) {
			res.append(words[i]);
			if (i != 0)
				res.append(" ");
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}

}
