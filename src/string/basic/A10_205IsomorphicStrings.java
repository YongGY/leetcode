package string.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 * @author William
 *
 */
public class A10_205IsomorphicStrings {
	
	public static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;

		if (s.length() != t.length())
			return false;

		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (map.containsKey(c1)) {
				if (map.get(c1) != c2)
					return false;
			} else {
				if (map.containsValue(c2))
					return false;
				map.put(c1, c2);
			}
		}
		return true;
	}
	
	
 	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "aa"));
	}
}
