package string.palindrome;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 * 
 * Example 1:
 * Input: "code"
 * Output: false
 * 
 * Example 2:
 * Input: "aab"
 * Output: true
 * 
 * Example 3:
 * Input: "carerac"
 * Output: true
 * 
 * @author William
 *
 */
public class A266_PalindromePermutation {
	
	public static boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}

		if (set.size() == 0 || set.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

 	public static void main(String[] args) {
 		System.out.println(canPermutePalindrome("code"));
 		System.out.println(canPermutePalindrome("aab"));
 		System.out.println(canPermutePalindrome("carerac"));
	}
}
