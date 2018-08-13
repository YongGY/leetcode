package string.basic;

import java.util.Arrays;

/**
 * 
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 *
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 * 
 * @author William
 * 
 * 这道题要求in-place做法，不能使用extra space, 那么，做法跟Rotate Array那道题非常相似
 * （1）reverse the whole array
 * （2）reverse each subarray seperated by ' '
 * 注意不要忘了reverse最后一个word
 *
 */
public class A08_186ReverseWordsInAStringII {
	
	public static void reverseWords(char[] s) {
		int pos = 0;
		for (int i = 0; i <= s.length; i++) {
			if (i < s.length && s[i] != ' ') {
				continue;
			}
			reverse(s, pos, i - 1);
			pos = i + 1;
		}
		System.out.println(Arrays.toString(s));
		reverse(s, 0, s.length - 1);
	}

	private static void reverse(char[] s, int from, int to) {
		while (from < to) {
			char c = s[from];
			s[from] = s[to];
			s[to] = c;
			from++;
			to--;
		}
	}
	
	
 	public static void main(String[] args) {
 		reverseWords(new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
	}
}
