package string.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 * @author William
 *
 */
public class A13_290WordPattern {
	
	public static boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		char[] cstr = pattern.toCharArray();
		if (arr.length != cstr.length) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < cstr.length; i++) {
			if (map.containsKey(cstr[i])) {
				if (map.get(cstr[i]) != arr[i]) {
					return false;
				}
			} else {
				map.put(cstr[i], arr[i]);
			}
		}
		return true;
	}
	
	
 	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}
}
