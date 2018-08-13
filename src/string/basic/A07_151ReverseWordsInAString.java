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

		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(" "+arr[i]);
			}
		}
		return sb.length() == 0 ? "" : sb.substring(1);
	}





	public static void main(String[] args) {
		System.out.println(reverseWords(" 1"));
	}

}
