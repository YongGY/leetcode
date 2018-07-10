package string.basic;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 首先判空，字符串为0的情况。
 * 从后向前遍历字符串的每个字符，使用s.charAt(i)，如果不等于空就计数；
 * 如果为空，并且计数不是0，就说明最后的单词已经记完数了，可以返回了。
 * 
 * @author William
 *
 */
public class A03_058LengthOfLastWord {
	
	public static int lengthOfLastWord(String s) {
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
			}else if (s.charAt(i) == ' ' && count != 0) {
				return count;
			}
		}
		return count;
	}

	
 	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a b"));
	}
}
